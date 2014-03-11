/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function onlyNumbers(evt)
{
    var e = event || evt;
    var charCode = e.which || e.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return false;
    }

    return true;

}
function onlyLetters(evt)
{
    var e = event || evt;
    var charCode = e.which || e.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return true;
    }

    return false;

}

function findDuplicates() {
jQuery.validator.addMethod("unique", function(value, element, params) {
    var prefix = params;
    var selector = jQuery.validator.format("[name!='{0}'][name^='{1}'][unique='{1}']", element.name, prefix);
    var matches = new Array();
    $(selector).each(function(index, item) {
        if (value == $(item).val()) {
            matches.push(item);
        }
    });

    return matches.length == 0;
}, "Value is not unique.");

jQuery.validator.classRuleSettings.unique = {
    unique: true
};
$("#selectSubjects").validate();

$("#makechoise").click(function() {
    $("#selectSubjects").valid();
});
}