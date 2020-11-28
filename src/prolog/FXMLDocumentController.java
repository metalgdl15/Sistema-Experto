/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.jpl7.*;


/**
 *
 * @author gnr_a
 */
public class FXMLDocumentController implements Initializable {
    
    
    //Nacimiento
    @FXML CheckBox boxTheria, boxPrototheria;
    
    //Desarrollo
    @FXML CheckBox boxEutheria, boxMetatheria;
    
    //Locacion
    @FXML CheckBox boxAfrica, boxAustralia, boxAmerica, boxAsia;
    
    //Alimentacion
    @FXML CheckBox boxOmnivoro, boxCarnivoro, boxHerbivoro, boxInsectivoro, boxFrugivoro;
    
    //Tamanyo
    @FXML CheckBox boxPequeno, boxMediano, boxGrande, boxMuyGrande;
    
    //Transporte
    @FXML CheckBox boxTerreste, boxAcuatico, boxSemiacuatico, boxArboricola;
    
    //Cabeza
    @FXML CheckBox boxHocicoAlargado, boxHocicoProboscide, boxLabioLeporino, boxOrejasLargas, boxPico, boxOjosDiminutos, boxOjosVestigiales, boxVisionDesarrollada, boxLenguaProtactil;
    
    //Morfologia
    @FXML CheckBox boxGarras, boxPatagio, boxEscamas, boxAletas, boxPlacaOsea, boxPezunas, boxPelaje, boxPuas, boxEscroto;
    @FXML CheckBox boxEspiraculo, boxUnasPlanas, boxArticulacionesXenartrales, boxColaPrensil, boxColaLarga, boxHuellasDigitales, boxSinMarsupio, boxRobusto, boxPielGuresa;
    
    //Dientes
    @FXML CheckBox boxCaninosDesarrollados, boxSinCaninos, boxCarnicerasDesarrolladas, boxDiastemaMarcado, boxSinDiastema, boxSinIncisivos, boxIncisivosDesarrollados, boxIncisivosNoDesarrollados, boxIncisivosHipertrofiados;
    @FXML CheckBox boxIncisivosClavija, boxDosInsicivos, boxDuplidentado, boxDiprotodonto, boxPoliprotodonto, boxSinDientes, boxDientesNoDesarrollados, boxCincuentaDientes, boxDientesTubulados;
    
    //Dedos
    @FXML CheckBox boxParDedos, boxImparDedos, boxMin4Dedos, boxPentadactilo, boxSindactilo, boxDedosPalmeados, box4Delanteros, box3Treaseros, box5Delanteros, box4Traseros, box5Traseros;
    
    //Comportamiento
    @FXML CheckBox boxDigitigrado, boxPlantigrado, boxUngulado, boxBipedo, boxNocturno, boxMacrosmatico, boxFosorial, boxVeneso, boxEcolocacion;
    
    @FXML TableView<String> tablaOrdenes;
    ObservableList <String> oblistOrdenes= FXCollections.observableArrayList();
    @FXML TableColumn<String, String> columnOrden;
    
    
    @FXML TableView<String> tablaFamilia;
    ObservableList <String> oblistFamilia= FXCollections.observableArrayList();
    @FXML TableColumn<String, String> columnFamilia;
    
    List<String> listaCaracteriticas = new ArrayList<>();    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        abrirArchivo();
        initNacimiento();
        initDesarrollo();
        initLocacion();
        initAlimentacion();
        initTamano();
        initTransporte();
        initCabeza();
        initMorfologia();
        initDientes();
        initDedos();
        initCompartamiento();
        imprimir();    
        
    }

    private void abrirArchivo(){
//        Query q1 = new Query("consult", new Term[]{new Atom("Taxonomia.pl")});
        
        String t1 =" consult('Taxonomia.pl')";
        Query q1 = new Query(t1);
        
        System.out.println("consult"+ (q1.hasSolution()? "succes": "failed"));

    }
    
    private void initNacimiento(){
        boxTheria.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, theria)");
                else
                    listaCaracteriticas.remove("caracteristica(X, theria)");
                
                consulta();
            }
        });
        
        boxPrototheria.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, prototheria)");
                else
                    listaCaracteriticas.remove("caracteristica(X, prototheria)");
                
                consulta();
            }
        });
    }
    
    private void initDesarrollo(){
        boxEutheria.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, eutheria)");
                else
                    listaCaracteriticas.remove("caracteristica(X, eutheria)");
                
                consulta();
            }
        });
        
        boxMetatheria.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, metatheria)");
                else
                    listaCaracteriticas.remove("caracteristica(X, metatheria)");
                
                consulta();
            }
        });
    }
    
    private void initLocacion(){
        boxAfrica.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, endemico_africa)");
                else
                    listaCaracteriticas.remove("caracteristica(X, endemico_africa)");
                
                consulta();
            }
        });
        
        boxAustralia.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, endemico_australia)");
                else
                    listaCaracteriticas.remove("caracteristica(X, endemico_australia)");
                
                consulta();
            }
        });
        
        boxAmerica.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, endemico_america)");
                else
                    listaCaracteriticas.remove("caracteristica(X, endemico_america)");
                
                consulta();
            }
        });
        
        boxAsia.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, endemico_asia)");
                else
                    listaCaracteriticas.remove("caracteristica(X, endemico_asia)");
                
                consulta();
            }
        });
    }
    
    private void initAlimentacion(){
        boxOmnivoro.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, omnivoro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, omnivoro)");
                
                consulta();
            }
        });
        
        boxCarnivoro.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, carnivoro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, carnivoro)");
                
                consulta();
            }
        });
        
        boxHerbivoro.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, herviboro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, herviboro)");
                
                consulta();
            }
        });
        
        boxInsectivoro.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, insectivoro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, insectivoro)");
                
                consulta();
            }
        });
        
        boxFrugivoro.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, frugivoro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, frugivoro)");
                
                consulta();
            }
        });
        
    }
    
    private void initTamano(){
        boxPequeno.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, pequeno)");
                else
                    listaCaracteriticas.remove("caracteristica(X, pequeno)");
                
                consulta();
            }
        });
        
        boxMediano.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, mediano)");
                else
                    listaCaracteriticas.remove("caracteristica(X, mediano)");
                
                consulta();
            }
        });
        
        boxGrande.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, grande)");
                else
                    listaCaracteriticas.remove("caracteristica(X, grande)");
                
                consulta();
            }
        });
        
        boxMuyGrande.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, muy_grande)");
                else
                    listaCaracteriticas.remove("caracteristica(X, muy_grande)");
                
                consulta();
            }
        });
    }
    
    private void initTransporte(){
        boxTerreste.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, terrestre)");
                else
                    listaCaracteriticas.remove("caracteristica(X, terrestre)");
                
                consulta();
            }
        });
        
        boxAcuatico.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, acuatico)");
                else
                    listaCaracteriticas.remove("caracteristica(X, acuatico)");
                
                consulta();
            }
        });
        
        boxSemiacuatico.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, semiacuatico)");
                else
                    listaCaracteriticas.remove("caracteristica(X, semiacuatico)");
                
                consulta();
            }
        });
        
        boxArboricola.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, arboricola)");
                else
                    listaCaracteriticas.remove("caracteristica(X, arboricola)");
                
                consulta();
            }
        });
    }
    
    private void initCabeza(){
        boxHocicoAlargado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, hocico_alargado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, hocico_alargado)");
                
                consulta();
            }
        });
        
        boxHocicoProboscide.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, hocico_proboscide)");
                else
                    listaCaracteriticas.remove("caracteristica(X, hocico_proboscide)");
                
                consulta();
            }
        });
        
        boxLabioLeporino.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, labio_leporino)");
                else
                    listaCaracteriticas.remove("caracteristica(X, labio_leporino)");
                
                consulta();
            }
        });
        
        boxOrejasLargas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, orejas_largas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, orejas_largas)");
                
                consulta();
            }
        });
        
        boxPico.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, pico)");
                else
                    listaCaracteriticas.remove("caracteristica(X, pico)");
                
                consulta();
            }
        });
        
        boxOjosDiminutos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, ojos_diminutos)");
                else
                    listaCaracteriticas.remove("caracteristica(X, ojos_diminutos)");
                
                consulta();
            }
        });
        
        boxOjosVestigiales.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, ojos_vestigiales)");
                else
                    listaCaracteriticas.remove("caracteristica(X, ojos_vestigiales)");
                
                consulta();
            }
        });
        
        boxVisionDesarrollada.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, vision_desarrollado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, vision_desarrollado)");
                
                consulta();
            }
        });
        
        boxLenguaProtactil.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, lengua_protactil)");
                else
                    listaCaracteriticas.remove("caracteristica(X, lengua_protactil)");
                
                consulta();
            }
        });
    }
    
    private void initMorfologia(){
        boxGarras.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, garras)");
                else
                    listaCaracteriticas.remove("caracteristica(X, garras)");
                
                consulta();
            }
        });
        
        boxPatagio.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, patagio)");
                else
                    listaCaracteriticas.remove("caracteristica(X, patagio)");
                
                consulta();
            }
        });
        
        boxEscamas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, escamas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, escamas)");
                
                consulta();
            }
        });
        
        boxAletas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, aletas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, aletas)");
                
                consulta();
            }
        });
        
        boxPlacaOsea.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, placa_osea)");
                else
                    listaCaracteriticas.remove("caracteristica(X, placa_osea)");
                
                consulta();
            }
        });
        
        boxPezunas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, pezunas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, pezunas)");
                
                consulta();
            }
        });
        
        boxPelaje.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, pelaje)");
                else
                    listaCaracteriticas.remove("caracteristica(X, pelaje)");
                
                consulta();
            }
        });
        
        boxPuas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, puas_o_espinas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, puas_o_espinas)");
                
                consulta();
            }
        });
        
        boxEscroto.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, escroto)");
                else
                    listaCaracteriticas.remove("caracteristica(X, escroto)");
                
                consulta();
            }
        });
        
        boxEspiraculo.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, espiraculo)");
                else
                    listaCaracteriticas.remove("caracteristica(X, espiraculo)");
                
                consulta();
            }
        });
        
        boxUnasPlanas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, unas_planas)");
                else
                    listaCaracteriticas.remove("caracteristica(X, unas_planas)");
                
                consulta();
            }
        });
        
        boxArticulacionesXenartrales.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, articulaciones_xenartrales)");
                else
                    listaCaracteriticas.remove("caracteristica(X, articulaciones_xenartrales)");
                
                consulta();
            }
        });
        
        boxColaPrensil.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, cola_prensil)");
                else
                    listaCaracteriticas.remove("caracteristica(X, cola_prensil)");
                
                consulta();
            }
        });
        
        boxColaLarga.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, cola_larga)");
                else
                    listaCaracteriticas.remove("caracteristica(X, cola_larga)");
                
                consulta();
            }
        });
        
        boxHuellasDigitales.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, huellas_digitales)");
                else
                    listaCaracteriticas.remove("caracteristica(X, huellas_digitales)");
                
                consulta();
            }
        });
        
        boxSinMarsupio.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sin_marsupio)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sin_marsupio)");
                
                consulta();
            }
        });
        
        boxRobusto.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, robusto)");
                else
                    listaCaracteriticas.remove("caracteristica(X, robusto)");
                
                consulta();
            }
        });
        
        boxPielGuresa.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, piel_gruesa)");
                else
                    listaCaracteriticas.remove("caracteristica(X, piel_gruesa)");
                
                consulta();
            }
        });
    }
    
    private void initDientes(){
        boxCaninosDesarrollados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, caninos_desarrollados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, caninos_desarrollados)");
                
                consulta();
            }
        });
        
        boxSinCaninos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sin_caninos)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sin_caninos)");
                
                consulta();
            }
        });
        
        boxCarnicerasDesarrolladas.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, carniceras_desarrollados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, carniceras_desarrollados)");
                
                consulta();
            }
        });
        
        boxDiastemaMarcado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, diastema_marcado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, diastema_marcado)");
                
                consulta();
            }
        });
        
        boxSinDiastema.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sin_diastema)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sin_diastema)");
                
                consulta();
            }
        });
        
        boxSinIncisivos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sin_incisivos)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sin_incisivos)");
                
                consulta();
            }
        });
        
        boxIncisivosDesarrollados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, incisivos_desarrollados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, incisivos_desarrollados)");
                
                consulta();
            }
        });
        
        boxIncisivosNoDesarrollados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, incisivos_no_desarrollados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, incisivos_no_desarrollados)");
                
                consulta();
            }
        });
        
        boxIncisivosHipertrofiados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, incisivos_hipertrofiados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, incisivos_hipertrofiados)");
                
                consulta();
            }
        });
        
        boxIncisivosClavija.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, incisivos_clavija)");
                else
                    listaCaracteriticas.remove("caracteristica(X, incisivos_clavija)");
                
                consulta();
            }
        });
        
        boxDosInsicivos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, incisivos_superiores_dos)");
                else
                    listaCaracteriticas.remove("caracteristica(X, incisivos_superiores_dos)");
                
                consulta();
            }
        });
        
        boxDuplidentado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, duplidentado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, duplidentado)");
                
                consulta();
            }
        });
        
        boxDiprotodonto.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, diprotodonto)");
                else
                    listaCaracteriticas.remove("caracteristica(X, diprotodonto)");
                
                consulta();
            }
        });
        
        boxPoliprotodonto.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, poliprotodonto)");
                else
                    listaCaracteriticas.remove("caracteristica(X, poliprotodonto)");
                
                consulta();
            }
        });
        
        boxSinDientes.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sin_dientes)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sin_dientes)");
                
                consulta();
            }
        });
        
        boxDientesNoDesarrollados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dientes_no_desarrollados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dientes_no_desarrollados)");
                
                consulta();
            }
        });
        
        boxCincuentaDientes.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dientes_cincuenta)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dientes_cincuenta)");
                
                consulta();
            }
        });
        
        boxDientesTubulados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dientes_tubulados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dientes_tubulados)");
                
                consulta();
            }
        });
    }
    
    private void initDedos(){
        boxParDedos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_pares)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_pares)");
                
                consulta();
            }
        });
        
        boxImparDedos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_impares)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_impares)");
                
                consulta();
            }
        });
        
        boxMin4Dedos.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_min_cuatro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_min_cuatro)");
                
                consulta();
            }
        });
        
        boxPentadactilo.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, pentadactilo)");
                else
                    listaCaracteriticas.remove("caracteristica(X, pentadactilo)");
                
                consulta();
            }
        });
        
        boxSindactilo.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, sindactilos)");
                else
                    listaCaracteriticas.remove("caracteristica(X, sindactilos)");
                
                consulta();
            }
        });
        
        boxDedosPalmeados.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_palmeados)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_palmeados)");
                
                consulta();
            }
        });
        
        box4Delanteros.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_delanteros_cuatro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_delanteros_cuatro)");
                
                consulta();
            }
        });
        
        box3Treaseros.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_traseros_tres)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_traseros_tres)");
                
                consulta();
            }
        });
        
        box5Delanteros.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_delanteros_cinco)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_delanteros_cinco)");
                
                consulta();
            }
        });
        
        box4Traseros.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_traseros_cuatro)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_traseros_cuatro)");
                
                consulta();
            }
        });
        
        box5Traseros.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, dedos_traseros_cinco)");
                else
                    listaCaracteriticas.remove("caracteristica(X, dedos_traseros_cinco)");
                
                consulta();
            }
        });
        
    }
    
    private void initCompartamiento(){
        boxDigitigrado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, digitigrado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, digitigrado)");
                
                consulta();
            }
        });
        
        boxPlantigrado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, plantigrado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, plantigrado)");
                
                consulta();
            }
        });
        
        boxUngulado.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, ungulado)");
                else
                    listaCaracteriticas.remove("caracteristica(X, ungulado)");
                
                consulta();
            }
        });
        
        boxBipedo.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, bipedo)");
                else
                    listaCaracteriticas.remove("caracteristica(X, bipedo)");
                
                consulta();
            }
        });
        
        boxNocturno.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, nocturno)");
                else
                    listaCaracteriticas.remove("caracteristica(X, nocturno)");
                
                consulta();
            }
        });
        
        boxMacrosmatico.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, macrosmatico)");
                else
                    listaCaracteriticas.remove("caracteristica(X, macrosmatico)");
                
                consulta();
            }
        });
        
        boxFosorial.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, fosorial)");
                else
                    listaCaracteriticas.remove("caracteristica(X, fosorial)");
                
                consulta();
            }
        });
        
        boxVeneso.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, venenoso)");
                else
                    listaCaracteriticas.remove("caracteristica(X, venenoso)");
                
                consulta();
            }
        });
        
        boxEcolocacion.selectedProperty().addListener(new ChangeListener<Boolean>(){        
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    listaCaracteriticas.add("caracteristica(X, ecolocacion)");
                else
                    listaCaracteriticas.remove("caracteristica(X, ecolocacion)");
                
                consulta();
            }
        });
    }
    @FXML
    private void consulta() {
        
        List<String> ordenes = new ArrayList<>();
        String text="";
        Query query=null;
        Map<String, Term>[] ss = null;
        
        if(listaCaracteriticas.size() != 0){    
            for (int i = 0; i < listaCaracteriticas.size(); i++) {
                if(i == 0)
                    text += listaCaracteriticas.get(i);
                else
                    text += ","+listaCaracteriticas.get(i);

            }

            query = new Query(text);

            ss = query.allSolutions();

            for (int i = 0; i < ss.length; i++) {
                System.out.println(ss[i].get("X"));
                ordenes.add(ss[i].get("X").toString());
            }

            System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        }

        oblistFamilia.clear();
        oblistOrdenes.setAll(ordenes);

    }
    
    private void imprimir(){
        columnOrden.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        oblistOrdenes.clear();
        tablaOrdenes.setItems(oblistOrdenes);
        
        
        columnFamilia.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        oblistFamilia.clear();
        tablaFamilia.setItems(oblistFamilia);
    }
    
    
    @FXML
    private void consultafamilias(){
        if(!tablaOrdenes.getSelectionModel().getSelectedItem().isEmpty() || tablaOrdenes.getSelectionModel().getSelectedItem() != null){
            
            String orden = tablaOrdenes.getSelectionModel().getSelectedItem();
            List<String> familias = new ArrayList<>();
            Query query = new Query("pertenece(X,"+ orden +")");
            Map<String, Term>[] ss = query.allSolutions();

            for (int i = 0; i < ss.length; i++) {
                familias.add(ss[i].get("X").toString());
            }

            oblistFamilia.setAll(familias);
    
        }
        
    }
        
    
}
