/**
 * Created by Илья on 29.09.2015.
 */

Ext.define('Brooklyn.model.ParentsCatalogModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'firstName', type: 'string'},
        {name: 'secondName', type: 'string'},
        {name: 'lastName', type: 'string'},
        {name: 'kin', type: 'string'},
        {name: 'phone', type: 'string'},
        {name: 'email', type: 'string'}]

});