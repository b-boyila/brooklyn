/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Brooklyn.view.ClientGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.clientGridView',
    width: 400,
    height: 300,
    frame: true,
    store: 'ClientCatalogStore',
    iconCls: 'icon-user',
    selType : 'checkboxmodel',
    viewConfig:{
        markDirty:false
    },
    columns: [
        {
            flex: 1,
            text: 'Дата запроса',
            format: 'd/m/Y',
            sortable: true,
            dataIndex: 'dateRequest'
        },
        {
            flex: 2,
            text: 'Имя',
            sortable: true,
            dataIndex: 'firstName'
        },
        {
            flex: 1,
            text: 'Телефон',
            sortable: true,
            dataIndex: 'phone'
        },
        {
            text: 'E-mail',
            flex: 1,
            sortable: true,
            dataIndex: 'email',
            vtype:'email'
        },
        {
            text: 'Статус',
            flex: 1,
            sortable: true,
            dataIndex: 'status'
        },
        {
            text: 'Комментарий',
            flex: 1,
            sortable: true,
            dataIndex: 'comment'
        }
    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add'
                },
                '-',
                {
                    action: 'delete',
                    text: 'Удалить',
                    iconCls: 'icon-delete',
                    disabled: false
                },
                {
                    xtype: 'tbfill'
                },
                {
                    xtype: 'panel',
                    html: '<a href="/j_spring_security_logout"/>Выход</a>'
                }
            ]
        }
    ]
});