/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Email.model.EmailModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'name', type: 'string'},
        {name: 'addressBook', type: 'string'},
        {name: 'emailPattern', type: 'string'}
    ]
});