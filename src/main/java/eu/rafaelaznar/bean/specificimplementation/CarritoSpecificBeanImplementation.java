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

public class CarritoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "cantidad",
            ShortName = "Cantidad carrito",
            LongName = "Cantidad carrito",
            Description = "Cantidad del producto en el carrito",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            IsForeignKeyDescriptor = true
    )
    private Integer cantidad;
    //--
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "id_producto",
            ShortName = "ID Producto",
            LongName = "ID de Producto",
            Description = "ID del Producto en el carrito",
            Type = EnumHelper.FieldType.Id,
            IsRequired = true,
            IsIdForeignKey = true,
            IsObjForeignKey = false,
            References = "producto"
    )
    private Integer id_producto = 0;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            IsId = false,
            Name = "obj_producto",
            ShortName = "OBJ Producto",
            LongName = "OBJ Producto",
            Description = "OBJ Producto del carrito",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            IsIdForeignKey = false,
            IsObjForeignKey = true,
            References = "producto"
    )
    private ProductoSpecificBeanImplementation obj_producto = null;

    public CarritoSpecificBeanImplementation() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public ProductoSpecificBeanImplementation getObj_producto() {
        return obj_producto;
    }

    public void setObj_producto(ProductoSpecificBeanImplementation obj_producto) {
        this.obj_producto = obj_producto;
    }



}
