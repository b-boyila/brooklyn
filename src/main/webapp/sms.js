Ext.application({
    name: 'Sms',
    appFolder : 'sms',

    views: [
        'SmsView',
        'SmsDeliveryGridView',
        'SmsPatternGridView',
        'AddressBookGridView',
        'AddSmsDeliveryFormView',
        'AddAddressBookFormView',
        'AddSmsPatternFormView'
    ],

    controllers : [
        'SmsController'
    ],

    stores : [


    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'smsView'
            }
        });
    }
});