/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Brooklyn.store.ClientCatalogStore', {
    extend: 'Ext.data.Store',
    model: 'Brooklyn.model.ClientCatalogModel',
    autoLoad: true,
    autoSync: false
});