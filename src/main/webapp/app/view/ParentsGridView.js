/**
 * Created by Илья on 17.09.2015.
 */

Ext.define('Brooklyn.view.ParentsGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.parentsGridView',
    height: 200,
    frame: true,
    store: 'ParentsCatalogStore',
    iconCls: 'icon-user',
    viewConfig:{
        markDirty:false
    },
    columns: [
        {
            flex: 1,
            text: 'Фамилия',
            sortable: true,
            dataIndex: 'secondName',
            editor: {
                xtype:'textfield'
            }
        },
        {
            flex: 1,
            text: 'Имя',
            sortable: true,
            dataIndex: 'firstName',
            editor: {
                xtype:'textfield'
            }
        },
        {
            flex: 1,
            text: 'Отчество',
            sortable: true,
            dataIndex: 'lastName',
            editor: {
                xtype:'textfield'
            }
        },
        {
            flex: 1,
            text: 'Родство',
            sortable: true,
            dataIndex: 'kin',
            editor: {
                xtype:'textfield'
            }
        },
        {
            flex: 1,
            text: 'Телефон',
            sortable: true,
            dataIndex: 'phone',
            editor: {
                xtype:'textfield'
            }
        },
        {
            text: 'E-mail',
            flex: 1,
            sortable: true,
            dataIndex: 'email',
            vtype: 'email',
            editor: {
                xtype:'textfield'
            }
        }
    ],
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2,
            saveBtnText: 'Сохранить',
            cancelBtnText: 'Отменить'
        })
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
                }
            ]
        }
    ]
});