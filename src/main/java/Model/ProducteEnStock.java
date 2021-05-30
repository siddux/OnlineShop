package Model;

import Model.components.*;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Objects;

public class ProducteEnStock {

    @BsonProperty(value = "component")
    private ComponentBase _component;
    @BsonProperty(value = "unitats_stock")
    private int _unitatsStock;
    @BsonProperty(value = "unitats_reservades")
    private int _unitatsReservades;

    public ProducteEnStock (ComponentBase component, int unitatsStock){
        this._component         = component;
        this._unitatsStock      = unitatsStock;
        this._unitatsReservades = 0;
    }

    public ProducteEnStock (ComponentBase component){

        this._component         = component;
        this._unitatsStock      = 0;
        this._unitatsReservades = 0;

    }

    public ProducteEnStock (){}

    public ProducteEnStock (int codiProducte){
        this._component = new ComponentBase(codiProducte);
    }

    public ComponentBase getProducte (){
        return new ComponentBase( this._component );
    }

    public int getUnitatsStock (){
        return _unitatsStock;
    }

    public void modificarUnitatsStock (int unitatsStock){
        this._unitatsStock += unitatsStock;
    }

    public void augmentarStock (){
        this._unitatsStock++;
    }

    public boolean disminuirStock (){
        if ( _unitatsStock > 0 ){
            this._unitatsStock--;
            return true;
        }
        return false;
    }

    public int getUnitatsReservades (){
        return _unitatsReservades;
    }

    public void modificarUnitatsReservades (int unitatsReservades){
        this._unitatsReservades += unitatsReservades;
    }

    public void augmentarReservades (){
        this._unitatsReservades++;
    }

    public boolean disminuirReservades (){
        if ( _unitatsReservades > 0 ){
            this._unitatsReservades--;
            return true;
        }
        return false;
    }

    @Override
    public String toString (){
        return _component.toString() + "\n" +
               "Unitats en stock: " + _unitatsStock + "\n";
    }

    @Override
    public boolean equals (Object o){
        if ( this == o ) return true;
        if ( !(o instanceof ProducteEnStock) ) return false;
        ProducteEnStock that = (ProducteEnStock) o;
        return _component.equals( that._component );
    }

    @Override
    public int hashCode (){
        return Objects.hash( _component );
    }
}
