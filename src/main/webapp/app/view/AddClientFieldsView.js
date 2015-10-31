/**
 * Created by Илья on 17.09.2015.
 */

Ext.define('Brooklyn.view.AddClientFieldsView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.addClientFieldsView',
    bodyStyle:'padding:5px 15px 10px',
    width: 890,
    items: [{
        layout:'column',
        items:[{
            columnWidth:.33,
            layout: 'form',
            items: [{
                xtype:'textfield',
                fieldLabel: 'Фамилия',
                name: 'secondName',
                anchor:'95%'
            }, {
                xtype:'datefield',
                format: 'd/m/y',
                fieldLabel: 'Дата рождения',
                name: 'happyBirthday',
                anchor:'95%',
                maxValue: new Date()  // limited to the current date or prior
            }, {
                name: 'status',
                xtype: 'combobox',
                fieldLabel: 'Статус',
                store:  {            // конфигурация хранилища
                        fields: ['domen', 'name'],
                    data: [
                        {"domen":"0.1", "name":"0,1"},
                        {"domen":"0.5", "name":"0,5"},
                        {"domen":"0.9", "name":"0,9"},
                        {"domen":"1", "name":"1"}
                    ]
                },
                displayField: 'name', // это текстовое значение <option>…</option>
                valueField: 'domen',  // а это значение поля <option value=»…»>
                anchor:'95%'
            }]
        },{
            columnWidth:.33,
            layout: 'form',
            items: [{
                xtype:'textfield',
                fieldLabel: 'Имя',
                name: 'firstName',
                anchor:'95%'
            },{
                xtype:'textfield',
                fieldLabel: 'Телефон',
                name: 'phone',
                regex: /^([0-9]{1,20})*$/,
                regexText: 'Телефон должна состоять из цифр',
                anchor:'95%'
            }]
        },{
            columnWidth:.33,
            layout: 'form',
            items: [{
                xtype:'textfield',
                fieldLabel: 'Отчество',
                name: 'lastName',
                anchor:'95%'
            },{
                xtype:'textfield',
                fieldLabel: 'Email',
                name: 'email',
                vtype:'email',
                anchor:'95%'
            }]
        }]
    }]
});