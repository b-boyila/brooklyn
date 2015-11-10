/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Sms.model.SmsModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'name', type: 'string'},
        {name: 'addressBook', type: 'string'},
        {name: 'smsPattern', type: 'string'}
    ]
});