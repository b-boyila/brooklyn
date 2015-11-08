Ext.application({
    name: 'Brooklyn',

    views: [
        'AddClientFormView',
        'ClientCatalogView',
        'ClientGridView',
        'SearchClientView',
        'UploadDataView',
        'ToolClientView',
        'AddClientFieldsView',
        'ParentsGridView',
        'StoryGridView',
        'SendEmailView',
        'SendSmsView'
    ],

    controllers : [
        'ClientCatalogController'
    ],

    stores : [
        'ClientCatalogStore',
        'ParentsCatalogStore',
        'StoryCatalogStore'

    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'clientCatalogView'
            }
        });
    }
});