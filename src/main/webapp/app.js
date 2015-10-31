Ext.application({
    name: 'Brooklyn',

    views: [
        'AddClientFormView',
        'ClientCatalogView',
        'ClientGridView',
        'SearchClientView',
        'SendClientView',
        'ToolClientView',
        'AddClientFieldsView',
        'ParentsGridView',
        'StoryGridView'
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