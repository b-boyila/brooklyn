/**
 * Created by Илья on 17.09.2015.
 */

Ext.define('Brooklyn.view.StoryGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.storyGridView',
    height: 200,
    frame: true,
    store: 'StoryCatalogStore',
    viewConfig:{
        markDirty:false
    },
    columns: [
        {
            flex: 1,
            text: 'Дата звонка',
            xtype:'datecolumn',
            format: 'd/m/Y',
            sortable: true,
            dataIndex: 'dateOfCall',
            editor: {
                xtype:'datefield'
            }
        },
        {
            text: 'Комментарий',
            flex: 2,
            sortable: true,
            dataIndex: 'comment',
            editor: {
                xtype: 'textfield'
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