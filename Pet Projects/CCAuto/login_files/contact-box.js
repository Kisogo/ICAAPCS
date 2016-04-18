'use strict';

(function(global) {

  $('#contact-link').click(function() {
    var template =
      '<div class="contact-box">'
      + '  <div class="contact-box-company-name">{{company_name}}</div>'
      + '  <table class="key-values">'
      + '   <colgroup>'
      + '     <col class="key-values-col1">'
      + '     <col class="key-values-col2">'
      + '   </colgroup>'
      + '   <tbody>'
      + '     {{#if website}}'
      + '       <tr>'
      + '         <td class="key-values-col1">Website</td>'
      + '         <td class="key-values-col2">{{website}}</td>'
      + '       </tr>'
      + '     {{/if}}'
      + '     {{#if public_email}}'
      + '       <tr>'
      + '         <td class="key-values-col1">E-mail address</td>'
      + '         <td class="key-values-col2">{{public_email}}</td>'
      + '       </tr>'
      + '     {{/if}}'
      + '     {{#if public_phone}}'
      + '       <tr>'
      + '         <td class="key-values-col1">Phone number</td>'
      + '         <td class="key-values-col2">{{public_phone}}</td>'
      + '       </tr>'
      + '     {{/if}}'
      + '     {{#if public_address}}'
      + '       <tr>'
      + '         <td class="key-values-col1">Address</td>'
      + '         <td class="key-values-col2">{{public_address}}</td>'
      + '       </tr>'
      + '     {{/if}}'
      + '   </tbody>'
      + '  </table>'
      + '</div>'

    var compiled = Handlebars.compile(template);

    var whiteLabelContext = $.extend({}, renderContext.whitelabel);
    whiteLabelContext.company_name = whiteLabelContext.comp_name;
    whiteLabelContext.website = whiteLabelContext.public_site;

    var html = compiled(whiteLabelContext);

    var venue = $.extend({}, renderContext.venue);
    if (venue.company_name || venue.public_email || venue.public_phone
      || venue.public_address || venue.website) {
      html += compiled(renderContext.venue);
    }

    messageBoxes.alert(html);

    return false;
  });

})(window);
