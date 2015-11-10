/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Brooklyn.model.ClientCatalogModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'firstName', type: 'string'},
        {name: 'secondName', type: 'string'},
        {name: 'lastName', type: 'string'},
        {name: 'happyBirthday', type: 'string'},
        {name: 'phone', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'status', type: 'string'}],

    proxy: {
        type: 'ajax',
        limitParam: 'size',
        startParam: undefined,
        api: {
            create: 'clients/create',
            read: 'clients/read',
            update: 'clients/update',
            destroy: 'clients/delete'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    },

    hasMany: [{model: 'Brooklyn.model.ParentsCatalogModel', name: 'parents', associationKey:'parents' },
              {model: 'Brooklyn.model.StoryCatalogModel', name: 'story', associationKey:'story'}
    ]
});