/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function callSave(select) {
                var parent = select.parentNode;
                
                var usedValues = {};
                
                for (var i = 0; i < parent.children.length; ++i) {
                    if (parent.children[i].value !== '') {
                        usedValues[ parent.children[i].value ] = parent.children[i];
                    }
                }
                for (var i = 0; i < parent.children.length; ++i) {
                    var s = parent.children[i];

                    for (var j = 0; j < s.children.length; ++j) {
                        var o = s.children[j];
                        var p = o.value === '' ? undefined : usedValues[o.value];

                        if (p === undefined || p === s) {
                            o.style.display = '';
                        }
                        else {
                            o.style.display = 'none';
                        }
                    }
                }
            }
