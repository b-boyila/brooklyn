/**
 * Created by ktagintsev on 09.10.15.
 */

Ext.define('Brooklyn.model.StoryCatalogModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'dateOfCall', type: 'string'},
        {name: 'comment', type: 'string'}
        ]

});