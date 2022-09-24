package controller;

import java.util.Date;

public interface IReservaController {
        public String listar(String username, boolean ordenar, String orden);
        public String crear(String idusuario, String fecha,int horario,int salonsocial);
}
