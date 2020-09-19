<?php
    
    require_once ('../model/ModelVoiture.php'); 

    class ControllerVoiture {
        
        public static function readAll() {
            $tab_v = ModelVoiture::getAllVoitures();     
            require ('../view/voiture/list.php');
        }
    
        public static function read() {
            $immat = $_GET['immat'];
            $v = ModelVoiture::getVoitureByImmat($immat);    
            require ('../view/voiture/detail.php');  
        }
    
        public static function create() {
            require ('../view/voiture/create.php');  
        }
    
        public static function created() {
            $immat = $_GET['immat'];
            $marque = $_GET['marque'];
            $couleur = $_GET['couleur'];
            $nvVoiture = new ModelVoiture($marque, $couleur, $immat);
            $nvVoiture->save();
            ControllerVoiture::readAll();
        }
        
    }
    
?>
