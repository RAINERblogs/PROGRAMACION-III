/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARCHIVO_OBJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-AL_100
 */
public class OperacionClienteTarjeta {
     List<Cliente> listaCliente;
    Scanner sd=new Scanner(System.in);
     public OperacionClienteTarjeta() {
        listaCliente=new ArrayList<>();
    
    }
    //metodos
    public void crearClienteTarjeta(){
        Cliente cliente=new Cliente();
        TarjetaDebito tarjeta=new TarjetaDebito();
        System.out.print("\nDigite nombre           : ");
        cliente.setNombre(sd.nextLine());
        System.out.print("Digite apellido paterno  : ");
        cliente.setPaterno(sd.nextLine());
        System.out.print("Digite apellido materno : ");
        cliente.setMaterno(sd.nextLine());
        System.out.print("Digite el nro. de cedula        : ");
        cliente.setCedula(sd.nextInt());
        //llenando los datos de la tarjeta
        System.out.print("Digite Nro. tarjeta       : ");
        tarjeta.setNroTarjeta(sd.nextInt());
        System.out.print("Digite Nro. cuenta        : ");
        tarjeta.setNroCuenta(sd.nextInt());
        System.out.print("Digite el saldo de la tarjeta : ");
        tarjeta.setSaldo(sd.nextDouble());
        tarjeta.setEstado("ACTIVO");
        //agregando la tarjeta de debito al cliente
        cliente.setTarjeta(tarjeta);
        //adicionando el cliente a la listaCliente
        listaCliente.add(cliente);
        System.out.println("--- REGISTRO COMPLETO -----");
        
    }
    public void mostrarCliente(){
        if(listaCliente!=null){
            System.out.println("--- CLIENTES ACTIVOS ---");
            for(Cliente clienteAux:listaCliente){
                clienteAux.mostrarCliente();
            }
        }
    }
    //Cambiando el estado de la tarjeta a INACTIVO para bloquear su uso
    public void cambiarEstado(int cedula){
        int sw=0;
        if(listaCliente!=null){
            for(Cliente cliente:listaCliente){
                if(cliente.getCedula()==cedula){
                    sw=1;
                    cliente.getTarjeta().setEstado("INACTIVO");
                    System.out.println("Se BLOQUEO la tarjeta");
                }
            }
            if(sw==0){
                System.out.println("\nEl cliente no esta registrado\n");
            }
        }
    }
    //realizando el deposito de un monto de dinero a la cuenta
    public void depositar(int cedula,double monto){
        int sw=0;
        if(listaCliente!=null){
            for(Cliente cliente:listaCliente){
                if(cliente.getCedula()==cedula){
                    sw=1;
                    if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                        double saldo=cliente.getTarjeta().getSaldo();
                        saldo=saldo+monto;
                        cliente.getTarjeta().setSaldo(saldo);
                        System.out.println("--------------\n    Se realizo el deposito \n-----------------------");
                    }else{
                        System.out.println("\nLa tarjeta esta bloquedo");
                        System.out.println("Comuniquese con el Banco!\n");
                    }
                }
            }
            if(sw==0){
                System.out.println("\n  El cliente no esta registrado !\n");
            }
        }
    }
     //realizando el retiro de un monto de dinero de la cuenta
    public void retirar(int cedula,double monto){
        int sw=0;
        if(listaCliente!=null){
            for(Cliente cliente:listaCliente){
                if(cliente.getCedula()==cedula){
                    sw=1;
                    if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                        if(cliente.getTarjeta().getSaldo() > monto){
                            double saldo = cliente.getTarjeta().getSaldo() - monto;
                            cliente.getTarjeta().setSaldo(saldo);
                            System.out.println("Retiro Exitoso ... !!!! \n");
                        }else{
                            double sal = cliente.getTarjeta().getSaldo();
                            System.out.println("\nSALDO INSUFICIENTE PARA RETIRAR ESE MONTO!!! ");
                            System.out.println("SALDO DISPONIBLE : " + sal + "\n");
                        }
                    }else{
                        System.out.println("\nLa tarjeta esta bloquedo");
                        System.out.println("Comuniquese con el Banco!\n");
                    }
                }
            }
            if(sw==0){
                System.out.println("\nEl cliente no esta registrado\n");
            }
        }
    }
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\PROGRAMACION\\TercerAño\\archivoCliente.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoCliente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaCliente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerClientes(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoCliente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaCliente=(List<Cliente>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionClienteTarjeta.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
