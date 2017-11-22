/*
 * Copyright (c) 2017 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 *
 * trolleyes-server3: Helps you to develop easily AJAX web applications
 *               by copying and modifying this Java Server.
 *
 * Sources at https://github.com/rafaelaznar/trolleyes-server3
 *
 * trolleyes-server3 is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import java.util.Date;

public class PedidoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
        IsId = false,
        Name = "fecha",
        ShortName = "Fecha",
        LongName = "Fecha",
        Description = "Fecha del pedido",
        Type = EnumHelper.FieldType.Date,
        IsRequired = true,
        IsForeignKeyDescriptor = true
    )
    private Date fecha;
    
    @Expose
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "iva",
            ShortName = "Iva",
            LongName = "Iva",
            Description = "Iva del pedido",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            IsForeignKeyDescriptor = true
    )
    private int iva;
    
    @Expose
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "tiene_iva",
            ShortName = "Tiene Iva",
            LongName = "Tiene Iva",
            Description = "Tiene Iva el pedido",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsForeignKeyDescriptor = true
    )
    private int tiene_iva;
    

    //---
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "id_usuario",
            ShortName = "ID Usuario",
            LongName = "ID de Usuario",
            Description = "ID Usuario del pedido",
            Type = EnumHelper.FieldType.Id,
            IsRequired = true,
            IsIdForeignKey = true,
            IsObjForeignKey = false,
            References = "usuario"
    )
    private Integer id_usuario = 0;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "id_tipousuario",
            ShortName = "ID Tipousuario",
            LongName = "ID del Usuario",
            Description = "ID de Usuario del pedido",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            IsIdForeignKey = false,
            IsObjForeignKey = true,
            References = "usuario"
    )
    private UsuarioSpecificBeanImplementation obj_usuario = null;

    public PedidoSpecificBeanImplementation() {

    }

    public PedidoSpecificBeanImplementation(Integer id) {
        super(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioSpecificBeanImplementation getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(UsuarioSpecificBeanImplementation obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

    public int getTiene_iva() {
        return tiene_iva;
    }

    public void setTiene_iva(int tiene_iva) {
        this.tiene_iva = tiene_iva;
    }

//    @Override
//    public String getColumns() {
//        String strColumns = "";
//        strColumns += "id,";
//        strColumns += "fecha,";
//        strColumns += "iva,";
//        strColumns += "tiene_iva,";
//        strColumns += "id_usuario";
//        return strColumns;
//    }
//
//    @Override
//    public String getValues() {
//        String strColumns = "";
//        strColumns += id + ",";
//        strColumns += EncodingHelper.stringifyAndQuotate(fecha) + ",";
//        strColumns += iva + ",";
//        strColumns += tiene_iva + ",";
//        strColumns += id_usuario;
//        return strColumns;
//    }
//
//    @Override
//    public String toPairs() {
//        String strPairs = "";
//        strPairs += "fecha=" + EncodingHelper.stringifyAndQuotate(fecha) + ",";
//        strPairs += "iva=" + iva + ",";
//        strPairs += "tiene_iva=" + tiene_iva + ",";
//        strPairs += "id_usuario=" + id_usuario;
//        return strPairs;
//    }
//
//    @Override
//    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, UsuarioSpecificBeanImplementation oPuserBean_security, Integer expand) throws SQLException, Exception {
//        this.setId(oResultSet.getInt("id"));
//        this.setFecha(oResultSet.getDate("fecha"));
//        this.setIva(oResultSet.getInt("iva"));
//        this.setTiene_iva(oResultSet.getInt("tiene_iva"));
//        this.setId_usuario(oResultSet.getInt("id_usuario"));
//        if (expand > 0) {
//            UsuarioSpecificDaoImplementation oUsuarioDao = new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, null);
//            UsuarioSpecificBeanImplementation oUsuarioBean = (UsuarioSpecificBeanImplementation) oUsuarioDao.get(oResultSet.getInt("id_usuario"), expand - 1);
//            this.setObj_usuario(oUsuarioBean);
//        } else {
//            this.setId_usuario(oResultSet.getInt("id_usuario"));
//        }
//        return this;
//    }
}
