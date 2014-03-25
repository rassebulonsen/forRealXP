/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function callSave(select) {
                // get reference to parent div
                var parent = select.parentNode;

                // map to store already selected values; key is the selected option value, and value is the select itself
                var usedValues = {};

                // iterate through selects
                for (var i = 0; i < parent.children.length; ++i) {
                    // add value to the usedValues map it's not empty
                    if (parent.children[i].value != '') {
                        usedValues[ parent.children[i].value ] = parent.children[i];
                    }
                }

                // iterate through selects again
                for (var i = 0; i < parent.children.length; ++i) {
                    // select at index i
                    var s = parent.children[i];

                    // iterate through select options
                    for (var j = 0; j < s.children.length; ++j) {
                        // option at index j
                        var o = s.children[j];

                        // get select from usedValues for value of option o; if option is the empty one return undefined
                        var p = o.value == '' ? undefined : usedValues[o.value];

                        // if p is undefined it means option is unselected
                        // if p == s it means option is selected in select s
                        // if either of this conditions is met, option should be visible
                        if (p == undefined || p == s) {
                            o.style.display = '';
                        }
                        // option otherwise
                        else {
                            o.style.display = 'none';
                        }
                    }
                }
            }
