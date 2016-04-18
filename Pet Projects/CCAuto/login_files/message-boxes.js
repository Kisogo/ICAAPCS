'use strict';

(function(global) {

  // Export the class (which includes static properties like the Alert class).
  global.MessageBoxes = MessageBoxes;
  // Export a new instance of the class.
  global.messageBoxes = new MessageBoxes();

  // Time in seconds that it takes the background to darken
  var backdropTransitionTime = 0.15;
  // Time in seconds that it takes a message box to transition in
  var boxTransitionTime = 0.3;

  function MessageBoxes() {
    // Indicates whether the message box containers are in the DOM yet.
    this.staticRendered = false;

    // Queue of [box, callback] pairs, where box is an instance of MessageBox
    // (or a derived class) and callback is the function that will be called
    // with the result when the box closes (e.g. a Confirm box returns whether
    // the user clicked the OK button).
    //
    // The boxes are removed from the queue and shown one at a time, in
    // first-in-first-out order.
    this.queue = [];
    // Current instance of MessageBox being displayed
    this.currentBox = undefined;
    // The callback that should be called when the message box closes
    this.currentCallback = undefined;
  }

  /**
   * Render and bind the message box containers.
   */
  MessageBoxes.prototype.renderStatic = function renderStatic() {
    this.staticRendered = true;

    this.$container = $('<section class="message-boxes"></section>');
    this.$container.appendTo('body');

    // This subcontainer goes in the container created above.
    var html = '<section id="box-container"></section>';

    this.$container.html(html);

    this.$boxContainer = this.$container.find('#box-container');
  }

  /**
   * Render the message box containers if they have not yet been rendered.
   */
  MessageBoxes.prototype.ensureStatic = function ensureStatic() {
    if (!this.staticRendered)
      this.renderStatic();
  }

  /**
   * Add a message box and callback to the queue.
   *
   * Show the box if none are currently being shown.
   */
  MessageBoxes.prototype.enqueue = function enqueue(box, callback) {
    this.queue.push([box, callback]);

    if (!this.currentBox) {
      this.showNextInQueue();
      this.queueUnemptied();
    }
  }

  /**
   * Called when a message box closes. Call the callback with the result
   * (passed in as arguments to this function), clean up references and either
   * show the next box or indicate that there are none left.
   */
  MessageBoxes.prototype.boxClose = function boxClose() {
    if (typeof this.currentCallback !== 'undefined') {
      // If we have a callback, pass the result (in arguments) to it.
      this.currentCallback.apply(this, arguments);
    }

    this.currentBox = undefined;
    this.currentCallback = undefined;

    if (this.queue.length > 0)
      // Show the next box.
      this.showNextInQueue();
    else
      // No more boxes to show.
      this.queueEmptied();
  }

  /**
   * Called the queue is empty and has a message box inserted into it. Show
   * the box and then add a class one tick later so that it transitions in.
   */
  MessageBoxes.prototype.queueUnemptied = function queueUnemptied() {
    var self = this;

    if (this.hideTimer) {
      clearTimeout(this.hideTimer);
      this.hideTimer = null;
    }

    this.$container.show();

    setTimeout(function() {
      self.$container.addClass('message-boxes-visible');
      // Prevent the background from scrolling.
      $('body').addClass('message-boxes-visible');
    }, 0);
  }

  /**
   * Called when a message box closes and there are none left in the queue to
   * show. Fade the box containers out.
   */
  MessageBoxes.prototype.queueEmptied = function queueEmptied() {
    var self = this;

    this.hideTimer = setTimeout(function() {
      self.hideTimer = null;
      self.$container.hide();
    }, backdropTransitionTime * 1000);

    this.$container.removeClass('message-boxes-visible');
    // Restore whatever overflow CSS property the body had (normally allows
    // scrolling again).
    $('body').removeClass('message-boxes-visible');
  }

  /**
   * Pop a message box and callback from the front of the queue and show the
   * box.
   */
  MessageBoxes.prototype.showNextInQueue = function showNextInQueue() {
    // Make sure the box container have been rendered.
    this.ensureStatic();

    // Pop the first element of the queue.
    var el = this.queue.shift();

    this.currentBox = el[0];
    this.currentBox.on('close', this.boxClose.bind(this));
    this.currentBox.show(this.$boxContainer);

    this.currentCallback = el[1];
  }

  inherits(MessageBox, EventEmitter);
  function MessageBox(context) {
    // context is the object that tells the message box how to look and behave.
    // It is available through the life of the box in this.context.

    if (typeof context === 'undefined')
      throw new Error('No context given.');

    if (typeof context.message === 'undefined')
      throw new Error('No message given.');

    this.context = context;
  }

  /**
   * Render the box into the container and then, a tick or two later, add a
   * class to make it transition in.
   */
  MessageBox.prototype.show = function show(container) {
    var self = this;

    this.render(container);
    this.bindEvents();

    // Allow a custom class to be applied to the message box so that its
    // components can be styled for a special purpose.
    if (typeof this.context.class !== 'undefined')
      this.$el.addClass(this.context.class);

    // If we only wait one tick in WebKit, the box doesn't do its slide-down
    // transition most of the time, although its opacity transitions. Waiting
    // two ticks solves this problem.
    setTimeout(function() {
      setTimeout(function() {
        self.$el.addClass('message-box-visible');
      }, 0);
    }, 0);
  }

  /**
   * Clean up event handlers and DOM references to avoid memory leaks.
   */
  MessageBox.prototype.destroy = function destroy() {
    this.unbindEvents();

    this.$el.remove();
    this.$el = undefined;
  }

  /**
   * Hide the box and then, after it has finished closing, call .destroy and
   * emit the 'close' event with the result.
   *
   * The result is passed in as the method arguments, which are passed on when
   * emitting the close event. e.g. this.hide(1, 2, 3) will begin closing the
   * box and then, after the transition completes, emit a 'close' event with
   * arguments of 1, 2, 3.
   */
  MessageBox.prototype.hide = function hide() {
    var self = this;
    var args = arguments;

    setTimeout(function() {
      self.destroy();
      self.emit.bind(self, 'close').apply(self, args);
    }, boxTransitionTime * 1000);

    this.$el.removeClass('message-box-visible');
  }

  MessageBox.prototype.bindEvents = function bindEvents() {
    throw new Error('Not implemented.');
  }

  MessageBox.prototype.unbindEvents = function unbindEvents() {
    throw new Error('Not implemented.');
  }

  MessageBoxes.Alert = Alert;

  /**
   * Analogous to JavaScript's alert function, but with an optional
   * buttonTitle argument to change what the OK button says. Rather than
   * blocking, this calls the provided callback (if one is provided).
   *
   * Creates an Alert instance and adds it to the message box queue.
   */
  MessageBoxes.prototype.alert = function alert(message, buttonTitle, callback) {
    // If no button title was supplied, rename the arguments accordingly.
    if (typeof buttonTitle === 'function') {
      callback = buttonTitle;
      buttonTitle = undefined;
    }

    this.enqueue(new Alert({
      message: message,
      buttonTitle: buttonTitle
    }), callback);
  }

  inherits(Alert, MessageBox);
  function Alert() {
    Alert.super_.apply(this, arguments);
  }

  Alert.prototype.render = function render($container) {
    var self = this;

    var html =
        '<section class="message-box">'
      +   '<div id="body" class="message-box-body">'
      +   '</div>'
      +   '<div id="footer" class="message-box-footer">'
      +     '<button id="ok" type="button" class="btn btn-default">OK</button>'
      +   '</div>'
      + '</section>';

    this.$el = $(html);
    this.$body = this.$el.find('#body');
    this.$footer = this.$el.find('#footer');
    this.$ok = this.$el.find('#ok');

    // Customize the template.
    this.applyContextToTemplate();

    this.$el.appendTo($container);
  }

  /**
   * Call the super class destroy function, and then clean up event handlers
   * and element references that are particular to this subclass.
   */
  Alert.prototype.destroy = function destroy() {
    Alert.super_.prototype.destroy.apply(this, arguments);

    this.$body = undefined;
    this.$footer = undefined;
    this.$ok = undefined;
  }

  /**
   * Use the context to customize the template after it has been rendered.
   */
  Alert.prototype.applyContextToTemplate = function applyContextToTemplate() {
    var context = this.context;

    if (typeof context.message !== 'undefined')
      this.$body.html(context.message);

    if (typeof context.buttonTitle !== 'undefined')
      this.$ok.html(context.buttonTitle);

    // Hide buttons and footer if desired.
    if (typeof context.hideButton !== 'undefined' && context.hideButton) {
      this.$ok.remove();
      this.$footer.remove();
    }
  }

  Alert.prototype.bindEvents = function bindEvents() {
    this.$ok.on('click', this.onClickOk.bind(this));
  }

  Alert.prototype.unbindEvents = function unbindEvents() {
    this.$ok.off('click');
  }

  Alert.prototype.onClickOk = function onClickOk() {
    this.hide();
  }

  MessageBoxes.Confirm = Confirm;

  /**
   * Analogous to JavaScript's confirm function, but with optional options.
   * Rather than blocking, this calls the provided callback (if one is
   * provided).
   *
   * Creates a Confirm instance and adds it to the message box queue.
   */
  MessageBoxes.prototype.confirm = function confirm(message, options, callback) {
    // If only one argument is given, use empty options.
    if (typeof options === 'undefined') {
      options = {}
    }
    // If no options are given, rename the arguments and use empty options.
    else if (typeof options === 'function') {
      callback = options;
      options = {};
    }

    options.message = message;

    this.enqueue(new Confirm(options), callback);
  }

  inherits(Confirm, MessageBox);
  function Confirm() {
    Confirm.super_.apply(this, arguments);
  }

  Confirm.prototype.render = function render($container) {
    var self = this;

    var html =
        '<section class="message-box">'
      +   '<div id="body" class="message-box-body">'
      +   '</div>'
      +   '<div id="footer" class="message-box-footer">'
      +     '<button id="ok" type="button" class="btn btn-default">OK</button>'
      +     '<button id="cancel" type="button" class="btn btn-default">Cancel</button>'
      +   '</div>'
      + '</section>';

    this.$el = $(html);
    this.$body = this.$el.find('#body');
    this.$footer = this.$el.find('#footer');
    this.$ok = this.$el.find('#ok');
    this.$cancel = this.$el.find('#cancel');

    this.applyContextToTemplate();

    this.$el.appendTo($container);
  }

  /**
   * Call the super class destroy function, and then clean up event handlers
   * and element references that are particular to this subclass.
   */
  Confirm.prototype.destroy = function destroy() {
    Confirm.super_.prototype.destroy.apply(this, arguments);

    this.$body = undefined;
    this.$footer = undefined;
    this.$ok = undefined;
    this.$cancel = undefined;
  }

  /**
   * Use the context to customize the template after it has been rendered.
   */
  Confirm.prototype.applyContextToTemplate = function applyContextToTemplate() {
    var context = this.context;

    if (typeof context.message !== 'undefined')
      this.$body.html(context.message);

    if (typeof context.okButtonTitle !== 'undefined')
      this.$ok.html(context.okButtonTitle);

    if (typeof context.cancelButtonTitle !== 'undefined')
      this.$cancel.html(context.cancelButtonTitle);

    // Hide buttons and footer if desired.
    if (typeof context.hideButtons !== 'undefined' && context.hideButtons) {
      this.$ok.remove();
      this.$cancel.remove();
      this.$footer.remove();
    }
  }

  Confirm.prototype.bindEvents = function bindEvents() {
    this.$ok.on('click', this.hide.bind(this, true));
    this.$cancel.on('click', this.hide.bind(this, false));
  }

  Confirm.prototype.unbindEvents = function unbindEvents() {
    this.$ok.off('click');
    this.$cancel.off('click');
  }

  MessageBoxes.OptInWindow = OptInWindow;

  MessageBoxes.prototype.textBox = function textBox(message, callback) {
    this.enqueue(new TextBox({
      message: message
    }), callback);
  }

  inherits(TextBox, Alert);
  function TextBox() {
    TextBox.super_.apply(this, arguments);
  }

  TextBox.prototype.render = function render($container) {
    TextBox.super_.prototype.render.apply(this, arguments);

    var html = '<input id="text-box" class="form-control" type="text" />';

    var textBox = $(html);
    textBox.appendTo(this.$body);
    textBox.focus();

    this.$textBox = textBox;
  }

  TextBox.prototype.onClickOk = function onClickOk() {
    this.hide(this.$textBox.val());
  }

  TextBox.prototype.destroy = function destroy() {
    TextBox.super_.prototype.destroy.apply(this, arguments);
  }

  inherits(OptInWindow, Confirm);
  function OptInWindow() {
    OptInWindow.super_.apply(this, arguments);
  }

  OptInWindow.prototype.render = function render($container) {
    OptInWindow.super_.prototype.render.apply(this, arguments);
    var chkBoxMsg = 'I agree to the terms above'; // default check box message
    
    switch (this.context.showCheckbox){
      case '0': return;
      case '1': break; // Nothing changes
      default: chkBoxMsg = this.context.showCheckbox;
    }

    this.$ok.prop('disabled', true);

    var html =
        '<div class="tos-prompt-checkbox-container">'
      +   '<input id="checkbox" type="checkbox" />'
      +   '<label for="checkbox">' + chkBoxMsg +'</label>'
        '</div>';

    // If allow opt out sign in   
    if (this.context.allowOptoutSignin) {
      html = 
      '<div class="tos-prompt-checkbox-container">'
      + chkBoxMsg 
      +'</div>'
      +'<div>'
      +   '<input id="checkbox" type="checkbox" style="margin-right:5%"/>'
      +   '<label for="checkbox">I Agree</label>'
      +   '<input id="checkboxDisagree" type="checkbox" style="margin-right:5%;margin-left:25%"/>'
      +   '<label for="checkboxDisagree">I DO NOT Agree</label>'
      +'</div>';
    }

    var checkboxContainer = $(html);
    checkboxContainer.prependTo(this.$footer);

    this.$checkbox = checkboxContainer.find('#checkbox');
    this.$checkboxDisagree = checkboxContainer.find('#checkboxDisagree');
  }

  OptInWindow.prototype.bindEvents = function bindEvents() {
    OptInWindow.super_.prototype.bindEvents.apply(this, arguments);
    
    if (this.context.showCheckbox !== '0') {
      this.$checkbox.on('change', this.checkboxChange.bind(this));
      this.$checkboxDisagree.on('change', this.checkboxChange.bind(this));
    
    // If allow opt out sign in.
      if (this.context.allowOptoutSignin) {
        
        // Ensure only one box can be checked.
        var self =  this;
        this.$checkbox.on('change', function() {
          if (self.$checkbox.is(':checked') && self.$checkboxDisagree.is(':checked')) {
            self.$checkboxDisagree.prop('checked', false);
          }
        });
          
        this.$checkboxDisagree.on('change', function() {
          if (self.$checkbox.is(':checked') && self.$checkboxDisagree.is(':checked')) {
            self.$checkbox.prop('checked', false);
          }
        });
         // Unbind and rebind with more argument indicating whether it's a optout signin
        this.$ok.off('click');
        this.$ok.on('click', function () {
          self.hide(true, self.$checkboxDisagree.is(':checked'));
        });
      }
    }
  }

  OptInWindow.prototype.unbindEvents = function unbindEvents() {
    OptInWindow.super_.prototype.unbindEvents.apply(this, arguments);

    if (this.context.showCheckbox !== '0'){
      this.$checkbox.on('change', this.checkboxChange.bind(this));
      this.$checkboxDisagree.on('change', this.checkboxChange.bind(this));
    }
  }

  OptInWindow.prototype.checkboxChange = function checkboxChange() {
    this.$ok.prop('disabled', !this.$checkbox.is(':checked') && !this.$checkboxDisagree.is(':checked'));
  }

  OptInWindow.prototype.destroy = function destroy() {
    OptInWindow.super_.prototype.destroy.apply(this, arguments);

    this.$checkbox = undefined;
    this.$checkboxDisagree = undefined;
  }

  MessageBoxes.OptInWindow = OptInWindow;

  inherits(MessagingOptInWindow, Confirm);
  function MessagingOptInWindow() {
    MessagingOptInWindow.super_.apply(this, arguments);
  }

  MessagingOptInWindow.prototype.applyContextToTemplate = function applyContextToTemplate() {
    var context = this.context;
    var body =
        '<p>'
      +   'Do you agree to be opted in to ' + context.companyName
      +   '\'s service to gain free access to thousands of ' + context.companyName
      + ' free public WiFi access points as well as network-wide promotions?'
      + '</p>';

    this.$body.html(body);

    this.$ok.html(context.okButtonTitle); // agree
    this.$cancel.html(context.cancelButtonTitle); // disagree
  };
  MessageBoxes.MessagingOptInWindow = MessagingOptInWindow;

})(window);
