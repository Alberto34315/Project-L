/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.DAO;

/**
 *
 * @author AlbertoRS
 */
public interface DAO {
    /**
 * set boolean persist a true
 * Cualquier cambio en la instancia desencadena una acutalización automática de la tabla
 */
 void persist();
 /**
 * set boolean persist a false
 * Los cambios en la instancia no actualizan la tabla automáticamente. Se
 * requiere una llamada a save explícita para que se actualice la tabla
 */
 void detach();
 /**
 * Elimina en la tabla el elemento que coincida con esta instancia (mismo id)
 */
 void remove();
 /**
 * En caso de que id=-1 realiza un INSERT
 * En caso de que id>0 realiza un UPDATE
 * Estableciendo en la tabla los valores corrrespondientes a esta instancia
 */
 int save();

 /**
 * Ojo: tanto en save como remove, hay que tener en cuenta los cambios que ocurran
 * en las relaciones.
 */
}
