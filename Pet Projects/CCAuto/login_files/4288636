'use strict';

function AuthType(options) {
  if (typeof options.template !== 'undefined')
    this.template = options.template;

  if (typeof this.template === 'undefined')
    throw new Error('AuthType must have a template.');

  // basePath is the base for routes of this auth type.
  // e.g. Facebook uses /auth/facebook
  this.basePath = options.basePath;
  this.allAuthInstances = options.allAuthInstances;
  this.renderContext = options.renderContext;
  this.requireTempAuth = options.requireTempAuth;

  this.isPreview = this.renderContext.isPreview;
  this.requireTosAgree = !!this.renderContext.theme.opt_in_show;
  this.optInType = this.renderContext.venue.wifi_optin_type;

  this.$parent = options.$parent;
  // Render the template.
  this.$el = $('<li>' + this.template + '</li>');

  // Add this auth type's list item to the auth-options list.
  this.$parent.append(this.$el);

}

/**
 * A response from the server indicated that we successfully authenticated
 * with the portal, so now authenticate with the access point.
 */
AuthType.prototype.connect = function connect() {
  this.setWindowLocation('/connect');
}

AuthType.prototype.hideOtherTypes = function hideOtherTypes() {
  var self = this;

  // Loop over all immediate children of this.$parent
  this.$parent.find('> *').each(function(index, el) {
    var $el = $(el);

    if (!$el.is(self.$el))
      $el.hide();
  });
}

AuthType.prototype.showAllTypes = function showAllTypes() {
  // Show all immediate children of this.$parent
  this.$parent.find('> *').fadeIn();
}

// Called after the last authentication type is instantiated
AuthType.prototype.onAllTypesLoaded = function onAllTypesLoaded() {}

// Used since statements like "window.location = ..." cannot be stubbed for
// testing.
AuthType.prototype.setWindowLocation = function setWindowLocation(location) {
  window.location = location;
}


inherits(AuthTypeBaseForm, AuthType);
function AuthTypeBaseForm(options) {
  AuthTypeBaseForm.super_.call(this, options);
}

/**
 * To extend this function in an inherited class, replace with a new function
 * in that class and use
 * InheritedClass.super_.prototype.bindElements.call(this);
 */
AuthTypeBaseForm.prototype.bindElements = function bindElements() {
  this.$btn = this.$el.find('#btn');
  this.$form = this.$el.find('#form');

  this.$submit = this.$form.find('#submit');
  this.$cancel = this.$form.find('#cancel');

  this.$form.hide();
}

/**
 * To extend this function in an inherited class, replace with a new function
 * in that class and use
 * InheritedClass.super_.prototype.bindEvents.call(this);
 */
AuthTypeBaseForm.prototype.bindEvents = function bindEvents() {
  this.$btn.on('click', $.proxy(this.showForm, this));

  this.$submit.on('click', $.proxy(this.onClickSubmit, this));

  this.$cancel.on('click', $.proxy(this.cancel, this));
}

AuthTypeBaseForm.prototype.showForm = function showForm() {
  this.hideOtherTypes();
  this.$btn.hide();
  this.$form.fadeIn();
}

AuthTypeBaseForm.prototype.cancel = function cancel(e) {
  e.preventDefault();

  this.showAllTypes();
  this.$form.hide();
  this.$btn.fadeIn();
}

AuthTypeBaseForm.prototype.onClickSubmit = function onClickSubmit() {
  var values = this.getValues();

  if (!this.validate(values)) {
    return;
  }

  messagingOptIn($.proxy(this.onMessageOptInClicked, this));
};

AuthTypeBaseForm.prototype.onMessageOptInClicked = function() {
  var values = this.getValues();

  if (this.requireTosAgree) {
    tosPrompt($.proxy(this.onTosAgreed, this, values));
  }
  else {
    this.onTosAgreed(values);
  }
};

AuthTypeBaseForm.prototype.onTosAgreed = function onTosAgreed(values, OptoutSignin) {
  if (this.isPreview)
    return;

  /* If there's an option to signin without agreeing to the term,
     mark it with optout_signin and opted_in(used in campaign)
     will always be the opposite of optout_signin */
  if (typeof OptoutSignin == 'boolean') {
    values.optout_signin = OptoutSignin;
    values.opted_in = !OptoutSignin;
  }
  this.disableButtons(true);

  this.postData(values);
}

AuthTypeBaseForm.prototype.getValues = function getValues() {
  throw new Error('Auth types deriving from AuthTypeBaseForm and using'
    + '.onClickSubmit or .postData must implement .getValues');
}

AuthTypeBaseForm.prototype.validate = function validate(values) {
  throw new Error('Auth types deriving from AuthTypeBaseForm and using'
    + '.onClickSubmit or .postData must implement .validate');
}

AuthTypeBaseForm.prototype.getSubmitUri = function getSubmitUri() {
  return this.basePath;
}

AuthTypeBaseForm.prototype.onSubmitSuccess = function onSubmitSuccess() {
  this.connect();
}

AuthTypeBaseForm.prototype.postData = function postData(values) {
  var self = this;

  $.ajax({
    url: this.getSubmitUri(),
    type: 'POST',
    data: JSON.stringify(values),
    processData: false,
    contentType: 'application/json; charset=UTF-8',
    success: function() {
      self.onSubmitSuccess();
    },
    error: function() {
      self.disableButtons(false);
    }
  });
}

AuthTypeBaseForm.prototype.disableButtons = function disableButtons(disabled) {
  if (disabled) {
    this.$submit.attr('disabled', true);
    this.$cancel.attr('disabled', true);
  }
  else {
    this.$submit.removeAttr('disabled');
    this.$cancel.removeAttr('disabled');
  }
}

/* Set the dropdown list for days in selected month and year */
AuthTypeBaseForm.prototype.setDays = function setDays(month, year) {
  var i,
      numOfDays = {
                    '1': 31, '2': 28, '3': 31, '4': 30, '5': 31, '6': 30,
                    '7': 31, '8': 31, '9': 30, '10': 31, '11': 30, '12': 31
                  },
      days = numOfDays[month],
      date = this.$birthDate.val();
  if (year % 4 === 0 && year % 200 !== 0 && days === 28) {
    days = 29;
  }
  date = (date > days) ? days : date;

  if (days !== this.$birthDate.find('option').length) {
    this.$birthDate.empty();

    for (i = 1; i <= days; i++) {
        this.$birthDate.append($('<option />').val(i).html(i));
    }
    this.$birthDate.val(date);
  }
}

/* Set the dropdown list birth month and year */
AuthTypeBaseForm.prototype.setBirthday = function setBirthday() {
  var i,
      self = this,
      months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June', 'July', 'Aug','Sep', 'Oct', 'Nov', 'Dec'];

  this.$birthday.on('focus', function() {
    self.$birthday.remove();
    self.$birthdayFields.show();

    var current = new Date();
    for (i = current.getFullYear(); i > 1900; i--)
    {
      self.$birthYear.append($('<option />').val(i).html(i));
    }
    self.$birthYear.val(current.getFullYear() - 18);

    for (i = 0; i < 12; i++)
    {
      self.$birthMonth.append($('<option />').val(i+1).html(months[i]));
    }
    self.$birthMonth.val(current.getMonth() + 1);

    self.setDays(current.getMonth() + 1, current.getFullYear());
    self.$birthDate.val(current.getDate());
  });

  this.$birthMonth.on('change', function() {
    self.setDays(self.$birthMonth.val(), self.$birthYear.val());
  });

  this.$birthYear.on('change', function() {
    self.setDays(self.$birthMonth.val(), self.$birthYear.val());
  });
}


inherits(AuthTypeEmail, AuthTypeBaseForm);
function AuthTypeEmail(options) {
  AuthTypeEmail.super_.call(this, options);

  this.checkIncludedFields();

  this.bindElements();
  this.bindEvents();
}

AuthTypeEmail.prototype.checkIncludedFields = function checkIncludedFields() {
  this.includeBirthday = this.renderContext.theme.email_include_birthday;
  this.includeZipCode = this.renderContext.theme.email_include_zip_code;
}

AuthTypeEmail.prototype.bindElements = function bindElements() {
  AuthTypeEmail.super_.prototype.bindElements.call(this);

  this.$firstName = this.$el.find('#first-name');
  this.$lastName = this.$el.find('#last-name');
  this.$email = this.$el.find('#email');
  this.$birthday = this.$form.find('#birthday-email');
  this.$birthdayFields = this.$form.find('#birthday-email-fields');
  this.$birthYear = this.$el.find('#birthYear-email');
  this.$birthMonth = this.$el.find('#birthMonth-email');
  this.$birthDate = this.$el.find('#birthDate-email');
  this.$zipCode = this.$form.find('#zip-code');
}

AuthTypeEmail.prototype.bindEvents = function bindEvents() {
  AuthTypeEmail.super_.prototype.bindEvents.call(this);

  if (!this.includeZipCode) {
    this.$zipCode.remove();
  }

  if (!this.includeBirthday) {
    this.$birthday.remove();
    this.$birthdayFields.remove();
  }
  else {
    this.$birthdayFields.hide();
    this.setBirthday();
  }
}

AuthTypeEmail.prototype.getValues = function getValues() {
  var values = {
    first_name: this.$firstName.val().trim(),
    last_name: this.$lastName.val().trim(),
    email: this.$email.val().trim()
  };

  if (this.includeBirthday) {
    var bdInput = new Date(this.$birthYear.val(), this.$birthMonth.val(), this.$birthDate.val());
    bdInput.setMonth(bdInput.getMonth() - 1);
    values.birthday = bdInput.toISOString().slice(0,10);
    values.birthday_approximate = 0;
  }

  if (this.includeZipCode)
    values.zip_code = this.$zipCode.val().trim().toUpperCase();

  return values;
}

AuthTypeEmail.prototype.validate = function validate(values) {
  if (values.first_name.length === 0
    || values.last_name.length === 0) {
    messageBoxes.alert('Please enter your first and last names.');
    return false;
  }
  else if (values.email.length === 0 || !isEmail(values.email)) {
    messageBoxes.alert('Please enter a valid e-mail address.');
    return false;
  }

  if (this.includeBirthday && !values.birthday) {
    messageBoxes.alert('Please enter your birthday.');
    return false;
  }

  if (this.includeZipCode && (values.zip_code.length < 5
    || !values.zip_code.match(/^[\d-\sa-zA-Z]*$/))) {
    messageBoxes.alert('Please enter a valid ZIP code.');
    return false;
  }

  return true;
}


AuthTypeEmail.prototype.template = "<button id=\"btn\" class=\"btn btn-connect auth-step\" type=\"button\">\n  <i class=\"typcn typcn-at\"></i>\n  Connect with Email\n</button>\n<div id=\"form\" class=\"auth-form auth-step\">\n  <div class=\"auth-field-pairs group\">\n    <input class=\"form-control auth-field\" type=\"text\" id=\"first-name\" placeholder=\"First Name\" value=\"\">\n    <input class=\"form-control auth-field\" type=\"text\" id=\"last-name\" placeholder=\"Last Name\" value=\"\">\n  </div>\n  <input class=\"form-control auth-field\" type=\"email\" id=\"email\" placeholder=\"Email Address\" value=\"\">\n  <a id=\"suggestion\" value=\"\" href=\"#\"></a>\n  <input class=\"form-control auth-field\" type=\"text\" id=\"birthday-email\" placeholder=\"Birthday\" value=\"\">\n  <div class=\"auth-field-birthday group\" id=\"birthday-email-fields\">\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthYear-email\" placeholder=\"Year\" value=\"\"/>\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthMonth-email\" placeholder=\"Month\" value=\"\"/>\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthDate-email\" placeholder=\"Day\" value=\"\"/>\n  </div>\n  <input class=\"form-control auth-field\" type=\"text\" id=\"zip-code\" placeholder=\"ZIP Code\" maxlength=\"16\" value=\"\">\n  <div class=\"group\">\n    <button id=\"submit\" type=\"button\" class=\"btn btn-connect\">Connect</button>\n    <a id=\"cancel\" class=\"side-link\" href=\"#\">Cancel</a>\n  </div>\n</div>\n"

inherits(AuthTypeAirMiles, AuthTypeEmail);
function AuthTypeAirMiles(options) {
  AuthTypeAirMiles.super_.call(this, options);
}

AuthTypeAirMiles.prototype.checkIncludedFields = function checkIncludedFields() {
  this.includeBirthday = false;
  this.includeZipCode = false;
}

AuthTypeAirMiles.prototype.bindElements = function bindElements() {
  AuthTypeAirMiles.super_.prototype.bindElements.call(this);

  this.$collectorNumber = this.$el.find('#collector-number');
}

AuthTypeAirMiles.prototype.bindEvents = function bindEvents() {
  AuthTypeAirMiles.super_.prototype.bindEvents.call(this);

  this.$collectorNumber.on('keyup', this.spaceCollectorNum.bind(this));
}

/**
 * Space the numbers as they're typed, so they look like they do on the Air
 * Miles card.
 */
// This is not perfect.
AuthTypeAirMiles.prototype.spaceCollectorNum = function spaceCollectorNum(event) {
  if (event.keyCode === 8)
    return;

  var number = this.$collectorNumber.val().replace(/ /g, '');
  var sections = [];

  sections.push(number.substring(0, 4));
  if (number.length >= 4)
    sections.push(number.substring(4, 7));
  if (number.length >= 7)
    sections.push(number.substring(7, 11));

  this.$collectorNumber.val(sections.join(' '));
}

AuthTypeAirMiles.prototype.getValues = function getValues() {
  var emailValues = AuthTypeAirMiles.super_.prototype.getValues.call(this);

  return $.extend(emailValues, {
    // Remove the spaces.
    airmiles: this.$collectorNumber.val().trim().replace(/ /g, '')
  });
}

AuthTypeAirMiles.prototype.validate = function validate(values) {
  var validEmail = AuthTypeAirMiles.super_.prototype.validate.call(this, values);

  if (!validEmail)
    return false;

  // Check that the number from getValues has exactly 11 digits and nothing
  // else.
  if (!values.airmiles.trim().match(/^\d{11}$/)) {
    messageBoxes.alert('Please enter a valid Air Miles Collector Number.');
    return false;
  }

  return true;
}


AuthTypeAirMiles.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-airmiles\">\n  <img src=\"/img/airmiles.png\" alt=\"\">\n  Connect with Air Miles\n</button>\n<form id=\"form\" class=\"auth-form\">\n  <fieldset>\n    <div class=\"auth-field-pairs group\">\n      <input type=\"text\" class=\"form-control auth-field\" id=\"first-name\" placeholder=\"First Name\" value=\"\">\n      <input type=\"text\" class=\"form-control auth-field\" id=\"last-name\" placeholder=\"Last Name\" value=\"\">\n    </div>\n    <input type=\"email\" class=\"form-control auth-field\" id=\"email\" placeholder=\"Email Address\" value=\"\">\n    <input type=\"tel\" class=\"form-control auth-field\" id=\"collector-number\" placeholder=\"Collector Number\" value=\"\" maxlength=\"13\"/>\n    <div class=\"group\">\n      <button id=\"submit\" type=\"button\" class=\"btn btn-connect btn-connect-colored btn-airmiles\">Connect</button>\n      <a id=\"cancel\" class=\"side-link\" href=\"#\"><span>Cancel</span></a>\n    </div>\n  </fieldset>\n</form>"

inherits(AuthTypeBaseSimplePassport, AuthType);
function AuthTypeBaseSimplePassport(options) {
  AuthTypeBaseSimplePassport.super_.call(this, options);
}

AuthTypeBaseSimplePassport.prototype.bindElements = function bindElements() {
  this.$btn = this.$el.find('#btn');
};

AuthTypeBaseSimplePassport.prototype.bindEvents = function bindEvents() {
  this.$btn.on('click', $.proxy(this.onButtonClicked, this));
};

AuthTypeBaseSimplePassport.prototype.onButtonClicked = function onButtonClicked() {
  messagingOptIn($.proxy(this.onMessageOptInClicked, this));
};

AuthTypeBaseSimplePassport.prototype.onMessageOptInClicked = function onMessageOptInClicked(clickedAgree) {
  if (this.requireTosAgree) {
    tosPrompt($.proxy(this.redirect, this));
  }
  else {
    this.redirect();
  }
};

AuthTypeBaseSimplePassport.prototype.redirect = function redirect() {
  if (this.isPreview)
    return;
  this.setWindowLocation(
    this.basePath + (this.requireTempAuth == true ? '/temporary-authentication' : '')
  );
};


inherits(AuthTypeFacebook, AuthTypeBaseSimplePassport);
function AuthTypeFacebook(options) {
  AuthTypeFacebook.super_.call(this, options);

  this.checkinEnabled = this.renderContext.theme.enable_fb_checkin;

  this.bindElements();
  this.bindEvents();

  if (this.checkinEnabled) {
    var checkinPlaceholder = this.renderContext.theme.fb_checkin_msg;

    if (checkinPlaceholder)
      this.$checkinMessage.attr('placeholder', checkinPlaceholder);
  }
  else {
    this.$checkinForm.hide();
  }
}

AuthTypeFacebook.prototype.bindElements = function bindElements() {
  AuthTypeFacebook.super_.prototype.bindElements.call(this);

  this.$checkinForm = this.$el.find('#checkin-form');
  this.$checkin = this.$el.find('#checkin');
  this.$checkinMessage = this.$el.find('#checkin-message');
}

AuthTypeFacebook.prototype.bindEvents = function bindEvents() {
  AuthTypeFacebook.super_.prototype.bindEvents.call(this);

  var self = this;

  this.$checkin.on('change', function() {
    if (self.$checkin.is(':checked'))
      self.$checkinMessage.fadeIn('fast');
    else
      self.$checkinMessage.fadeOut('fast');
  });
}

AuthTypeFacebook.prototype.onButtonClicked = function onButtonClicked() {
  if (this.checkinEnabled // Venue has Facebook check-in enabled
    && this.$checkin.is(':checked') // The check-in checkbox is checked.
    // The check-in message field is empty.
    && !this.$checkinMessage.val().trim()
    // The venue has no Facebook page to check in at with an empty message.
    && !this.renderContext.venue.facebook_id) {
    messageBoxes.alert('Please enter a check-in message.');

    return;
  }

  AuthTypeFacebook.super_.prototype.onButtonClicked.call(this);
}

AuthTypeFacebook.prototype.redirect = function redirect() {
  var redirectPath = this.basePath + (this.requireTempAuth == true ? '/temporary-authentication' : '');

  if (!this.checkinEnabled || !this.$checkin.is(':checked')) {
    this.setWindowLocation(redirectPath);
    return;
  }

  var message = this.$checkinMessage.val();

  this.setWindowLocation(redirectPath + '?checkin=' + encodeURIComponent(message));
};


AuthTypeFacebook.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-facebook\">\n  <i class=\"typcn typcn-social-facebook\"></i>\n  Connect with Facebook\n</button>\n<div id=\"checkin-form\" class=\"group\">\n  <div>\n    <input type=\"checkbox\" id=\"checkin\" checked>\n    <label class=\"auth-label\" for=\"checkin\">Check into Facebook?</label>\n  </div>\n  <input class=\"form-control auth-field\" type=\"text\" id=\"checkin-message\" placeholder=\"Enjoying the free WiFi!\">\n</div>"

inherits(AuthTypeGoogle, AuthTypeBaseSimplePassport);
function AuthTypeGoogle(options) {
  AuthTypeGoogle.super_.call(this, options);

  AuthTypeGoogle.super_.prototype.bindElements.call(this);
  AuthTypeGoogle.super_.prototype.bindEvents.call(this);
}

AuthTypeGoogle.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-google\">\n  <i class=\"typcn typcn-social-google-plus\"></i>\n  Connect with Google\n</button>"

inherits(AuthTypeGuest, AuthType);
function AuthTypeGuest(options) {
  AuthTypeGuest.super_.call(this, options);

  this.bindElements();
  this.bindEvents();

  var guest = this.renderContext.theme.guest_checkin_msg;
  this.$link.text(guest || 'CONNECT AS GUEST');
}

AuthTypeGuest.prototype.onAllTypesLoaded = function onAllTypesLoaded() {
  var parent = this.$el.parent();

  // Move our element to the bottom.
  parent.append(this.$el);

  // Show only the link if there are multiple auth options, or the button if we
  // are the only one.
  if (parent.children().length <= 1)
    this.$link.remove();
  else
    this.$btn.remove();
}

AuthTypeGuest.prototype.bindElements = function bindElements() {
  this.$link = this.$el.find('#link');
  this.$btn = this.$el.find('#btn');
}

AuthTypeGuest.prototype.bindEvents = function bindEvents() {
  this.$link.on('click', $.proxy(this.onButtonClicked, this));
  this.$btn.on('click', $.proxy(this.onButtonClicked, this));
}

AuthTypeGuest.prototype.onButtonClicked = function onButtonClicked(e) {
  var self = this;
  
  e.preventDefault();

  if (this.isPreview)
    return;

  this.$btn.attr('disabled', true);

  $.ajax({
    url: this.basePath,
    type: 'POST',
    data: '{}',
    processData: false,
    contentType: 'application/json; charset=UTF-8',
    success: function() {
      self.connect();
    },
    error: function() {
      self.$btn.attr('disabled', false);
    }
  });
}

AuthTypeGuest.prototype.template = "<a id=\"link\" class=\"side-link guest-link\" href=\"#\"></a>\n<button id=\"btn\" class=\"btn btn-connect btn-foreground-colored\">\n  Connect\n</button>"

inherits(AuthTypeLinkedin, AuthTypeBaseSimplePassport);
function AuthTypeLinkedin(options) {
  AuthTypeLinkedin.super_.call(this, options);

  AuthTypeLinkedin.super_.prototype.bindElements.call(this);
  AuthTypeLinkedin.super_.prototype.bindEvents.call(this);
}

AuthTypeLinkedin.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-linkedin\">\n  <i class=\"typcn typcn-social-linkedin\"></i>\n  Connect with LinkedIn\n</button>"

inherits(AuthTypePassportId, AuthType);
function AuthTypePassportId(options) {
  AuthTypePassportId.super_.call(this, options);

  this.bindElements();
  this.bindEvents();

  this.$customMsg.html(this.renderContext.theme.passport_national_id_msg);
}

/**
 * To extend this function in an inherited class, replace with a new function
 * in that class and use
 * InheritedClass.super_.prototype.bindElements.call(this);
 */
AuthTypePassportId.prototype.bindElements = function bindElements() {
  this.$form = this.$el.find('#passport-id-form');
  this.$customMsg = this.$form.find('#custom-msg');
  this.$passportId = this.$form.find('#passport-id');
  this.$submit = this.$form.find('#submit');
}

/**
 * To extend this function in an inherited class, replace with a new function
 * in that class and use
 * InheritedClass.super_.prototype.bindEvents.call(this);
 */
AuthTypePassportId.prototype.bindEvents = function bindEvents() {
  this.$passportId.on('keydown', function(e) {
    // No spaces
    if (e.keyCode === 32)
      e.preventDefault();
  });

  this.$submit.on('click', $.proxy(this.onClickSubmit, this));
}

AuthTypePassportId.prototype.onAllTypesLoaded = function onAllTypesLoaded() {
  this.hideOtherTypes();
}

AuthTypePassportId.prototype.onClickSubmit = function onClickSubmit() {
  if (this.isPreview) {
    this.done();
    return;
  }

  var passportId = this.$passportId.val().trim();

  if (!this.validate(passportId))
    return;

  this.$submit.attr('disabled', true);

  this.post(passportId);
}

AuthTypePassportId.prototype.validate = function validate(passportId) {
  if (passportId.length === 0) {
    messageBoxes.alert('Please enter a valid Passport ID/National ID.');
    return false;
  }

  return true;
}

AuthTypePassportId.prototype.post = function post(passportId) {
  var self = this;

  $.ajax({
    url: this.basePath,
    type: 'POST',
    data: JSON.stringify({passport_id: passportId}),
    processData: false,
    contentType: 'application/json; charset=UTF-8',
    success: function() {
      self.done();
    },
    error: function() {
      self.$submit.removeAttr('disabled');
    }
  });
}

AuthTypePassportId.prototype.done = function done() {
  this.showAllTypes();
  this.$form.hide();
}

AuthTypePassportId.prototype.template = "<div id=\"passport-id-form\">\n  <div id=\"standard-msg\">Please enter your Passport ID/National ID:</div>\n  <div id=\"custom-msg\"></div>\n  <input class=\"form-control auth-field\" type=\"text\" id=\"passport-id\" placeholder=\"Passport ID/National ID\" value=\"\" maxlength=\"13\"/>\n  <button id=\"submit\" type=\"button\" class=\"btn btn-connect\">Submit Passport ID/National ID</button>\n</div>"

inherits(AuthTypeSMS, AuthTypeBaseForm);
function AuthTypeSMS(options) {
  AuthTypeSMS.super_.call(this, options);

  this.haveCodeAlready = options.haveCodeAlready;

  this.includeEmail = this.renderContext.theme.sms_include_email;
  this.includeBirthday = this.renderContext.theme.sms_include_birthday;
  this.includeZipCode = this.renderContext.theme.sms_include_zip_code;

  this.bindElements();
  this.bindEvents();

  this.$verifyForm.hide();

  // This jQuery plugin makes phone number inputs prettier, formats the number
  // as it's typed and lets the user select a country phone code by selecting
  // from a list of national flags.
  //
  // https://github.com/Bluefieldscom/intl-tel-input
  this.$phone.intlTelInput({
    defaultCountry: options.venueCountryCode,
    autoFormat: true,
    responsiveDropdown: true,
    utilsScript: '/components/intl-tel-input/lib/libphonenumber/build/utils.js'
  });

}

AuthTypeSMS.prototype.bindElements = function bindElements() {
  AuthTypeSMS.super_.prototype.bindElements.call(this);

  this.$firstName = this.$form.find('#first-name');
  this.$lastName = this.$form.find('#last-name');
  this.$phone = this.$form.find('#phone');
  this.$email = this.$form.find('#email');
  this.$birthday = this.$form.find('#birthday-sms');
  this.$birthdayFields = this.$form.find('#birthday-sms-fields');
  this.$birthYear = this.$el.find('#birthYear-sms');
  this.$birthMonth = this.$el.find('#birthMonth-sms');
  this.$birthDate = this.$el.find('#birthDate-sms');
  this.$zipCode = this.$form.find('#zip-code');
  this.$haveCodeBtn = this.$form.find('#have-code');

  this.$verifyForm = this.$el.find('#sms-verify-form');
  this.$verifyCode = this.$verifyForm.find('#code');
  this.$verifyBtn = this.$verifyForm.find('#verify');
  this.$verifyBackBtn = this.$verifyForm.find('#back');
}

AuthTypeSMS.prototype.bindEvents = function bindEvents() {
  AuthTypeSMS.super_.prototype.bindEvents.call(this);
  var self = this;

  if (!this.includeEmail)
    this.$email.remove();

  if (!this.includeZipCode)
    this.$zipCode.remove();

  if (!this.includeBirthday) {
    this.$birthday.remove();
    this.$birthdayFields.remove();
  }
  else {
    this.$birthdayFields.hide();
    this.setBirthday();
  }

  if (this.haveCodeAlready) {
    // Note that we do not remove the event listener from AuthTypeBaseForm
    // that takes us to the input form and hides the other auth types. This
    // listener runs immediately after it, taking us to the verify form.
    this.$btn.on('click', this.showVerifyForm.bind(this));
  }
  else {
    this.$haveCodeBtn.hide();
  }

  this.$haveCodeBtn.on('click', function(e) {
    e.preventDefault();

    self.showVerifyForm();
  });

  this.$verifyBackBtn.on('click', function(e) {
    e.preventDefault();

    self.$verifyForm.hide();
    self.$form.fadeIn();
  });

  this.$verifyBtn.on('click', this.onClickVerify.bind(this));
}

AuthTypeSMS.prototype.getValues = function getValues() {
  var values = {
    first_name: this.$firstName.val().trim(),
    last_name: this.$lastName.val().trim(),
    phone: this.$phone.intlTelInput('isValidNumber')
      ? this.$phone.intlTelInput('getNumber')
      : undefined
  };

  if (this.includeEmail)
    values.email = this.$email.val().trim();

  if (this.includeZipCode)
    values.zip_code = this.$zipCode.val().trim().toUpperCase();

  if (this.includeBirthday) {
    var bdInput = new Date(this.$birthYear.val(), this.$birthMonth.val(), this.$birthDate.val());
      bdInput.setMonth(bdInput.getMonth() - 1);
      values.birthday = bdInput.toISOString().slice(0,10);
      values.birthday_approximate = 0;
  }
  return values;
}

AuthTypeSMS.prototype.validate = function validate(values) {
  if (values.first_name.length === 0
    || values.last_name.length === 0) {
    messageBoxes.alert('Please enter your first and last names.');
    return false;
  }

  if (typeof values.phone === 'undefined') {
    messageBoxes.alert('Please enter a valid phone number.');
    return false;
  }

  if (this.includeEmail && (values.email.length === 0
    || !isEmail(values.email))) {
    messageBoxes.alert('Please enter a valid e-mail address.');
    return false;
  }

  if (this.includeBirthday && !values.birthday) {
    messageBoxes.alert('Please enter your birthday.');
    return false;
  }

  if (this.includeZipCode && (values.zip_code.length < 5
    || !values.zip_code.match(/^[\d-\sa-zA-Z]*$/))) {
    messageBoxes.alert('Please enter a valid ZIP code.');
    return false;
  }

  return true;
}

// Override AuthTypeBaseForm.prototype.onClickSubmit, which opens the ToS
// prompt.
AuthTypeSMS.prototype.onClickSubmit = function onClickSubmit() {
  var values = this.getValues();

  if (!this.validate(values))
    return;

  if (this.isPreview) {
    this.onSubmitSuccess();
    return;
  }

  this.disableButtons(true);

  this.postData(values);
}

AuthTypeSMS.prototype.onSubmitSuccess = function onSubmitSuccess() {
  this.disableButtons(false);

  this.showVerifyForm();

  this.$haveCodeBtn.show();
}

AuthTypeSMS.prototype.showVerifyForm = function showVerifyForm() {
  this.$form.hide();
  this.$verifyForm.fadeIn();
}

AuthTypeSMS.prototype.onClickVerify = function onClickVerify() {
  var code = this.$verifyCode.val().trim();

  if (!this.validateCode(code))
    return;

  if (this.isPreview) {
    this.onVerifySuccess();
    return;
  }

  this.disableButtons(true);

  $.ajax({
    url: this.basePath + '/verify',
    type: 'POST',
    data: JSON.stringify({code: code}),
    processData: false,
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    success: this.onVerifySuccess.bind(this),
    error: this.onVerifyError.bind(this)
  });
}


AuthTypeSMS.prototype.onVerifySuccess = function onVerifySuccess(res) {
  this.disableButtons(false);

  messagingOptIn($.proxy(this.showTosPrompt, this));
};

AuthTypeSMS.prototype.showTosPrompt = function showTosPrompt () {
  if (this.requireTosAgree)
    tosPrompt($.proxy(this.onTosAgreed, this));
  else
    this.onTosAgreed();
};

AuthTypeSMS.prototype.onVerifyError = function onVerifyError(res) {
  this.disableButtons(false);

  var code = res.responseJSON.code;

  if (code === 'expired')
    messageBoxes.alert('Your code has expired. Please go back and try again.');
  else if (code === 'incorrect')
    messageBoxes.alert('You entered an incorrect code.');
}

AuthTypeSMS.prototype.onTosAgreed = function onTosAgreed() {
  if (this.isPreview)
    return;

  this.connect();
}

AuthTypeSMS.prototype.disableButtons = function disableButtons(disabled) {
  AuthTypeSMS.super_.prototype.disableButtons.call(this, disabled);

  if (disabled) {
    this.$haveCodeBtn.attr('disabled', true);
    this.$verifyBtn.attr('disabled', true);
    this.$verifyBackBtn.attr('disabled', true);
  }
  else {
    this.$haveCodeBtn.removeAttr('disabled');
    this.$verifyBtn.removeAttr('disabled');
    this.$verifyBackBtn.removeAttr('disabled');
  }
}

AuthTypeSMS.prototype.validateCode = function validateCode(code) {
  if (!code.match(/^\d{4}$/)) {
    messageBoxes.alert('Please enter a 4-digit code.');
    return false;
  }

  return true;
}


AuthTypeSMS.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-sms\">\n  <i class=\"typcn typcn-device-phone\"></i>\n  Connect with SMS\n</button>\n<div id=\"form\" class=\"auth-form sms-input-form\">\n  <fieldset>\n    <div class=\"auth-field-pairs group\">\n      <input class=\"form-control auth-field\" type=\"text\" id=\"first-name\" placeholder=\"First Name\" value=\"\">\n      <input class=\"form-control auth-field\" type=\"text\" id=\"last-name\" placeholder=\"Last Name\" value=\"\">\n    </div>\n    <input class=\"form-control auth-field\" type=\"tel\" id=\"phone\" placeholder=\"Phone Number\" value=\"\">\n    <input class=\"form-control auth-field\" type=\"email\" id=\"email\" placeholder=\"Email Address\" value=\"\">\n     <input class=\"form-control auth-field\" type=\"text\" id=\"birthday-sms\" placeholder=\"Birthday\" value=\"\">\n    <div class=\"auth-field-birthday group\" id=\"birthday-sms-fields\">\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthYear-sms\" placeholder=\"Year\" value=\"\"/>\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthMonth-sms\" placeholder=\"Month\" value=\"\"/>\n    <select class=\"form-control auth-field\" type=\"text\" id=\"birthDate-sms\" placeholder=\"Day\" value=\"\"/>\n  </div>\n    <input class=\"form-control auth-field\" type=\"text\" id=\"zip-code\" placeholder=\"ZIP Code\" maxlength=\"16\" value=\"\">\n  </fieldset>\n  <div class=\"actions group\">\n    <button id=\"submit\" class=\"btn btn-connect\" type=\"button\">Submit</button>\n    <a href=\"#\" id=\"have-code\" class=\"side-link\"><span>Have Code already?</span></a>\n    <a href=\"#\" id=\"cancel\" class=\"side-link\"><span>Cancel</span></a>\n  </div>\n</div>\n<div id=\"sms-verify-form\" class=\"auth-form\">\n  <p>Enter the code you receive by text message below.</p>\n  <input id=\"code\" class=\"form-control auth-field\" type=\"number\" maxlength=\"13\">\n  <input id=\"verify\" class=\"btn btn-connect\" type=\"button\" value=\"Verify\">\n  <div class=\"actions group\">\n    <a href=\"#\" class=\"side-link\" id=\"back\"><span>Back</span></a>\n  </div>\n</div>"

inherits(AuthTypeTwitter, AuthTypeBaseSimplePassport);
function AuthTypeTwitter(options) {
  AuthTypeTwitter.super_.call(this, options);

  AuthTypeTwitter.super_.prototype.bindElements.call(this);
  AuthTypeTwitter.super_.prototype.bindEvents.call(this);
}

AuthTypeTwitter.prototype.template = "<button id=\"btn\" class=\"btn btn-connect btn-connect-colored btn-twitter\">\n  <i class=\"typcn typcn-social-twitter\"></i>\n  Connect with Twitter\n</button>"

