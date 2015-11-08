/**
 * Created by ???? on 02.09.2015.
 */
Ext.define('Email.view.EmailView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.emailView',
    layout: 'accordion',
    items: [
        {
            xtype: 'emailDeliveryGridView',
            title: 'Создать рассылку',
            region: 'west',
            collapsed: true

        },
        {
            xtype: 'addressBookGridView',
            title: 'Адресные книги',
            region: 'west',
            width: 280,
            collapsed: true
        },
        {
            xtype: 'emailPatternGridView',
            title: 'Шаблоны сообщений',
            region: 'west',
            width: 280,
            collapsed: true
        }
    ]
});