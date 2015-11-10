Ext.application({
    name: 'Email',
    appFolder : 'email',

    views: [
        'EmailView',
        'EmailDeliveryGridView',
        'EmailPatternGridView',
        'AddressBookGridView',
        'AddEmailDeliveryFormView',
        'AddAddressBookFormView',
        'AddEmailPatternFormView'
    ],

    controllers : [
         'EmailController'
    ],

    stores : [


    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'emailView'
            }
        });
    }
});