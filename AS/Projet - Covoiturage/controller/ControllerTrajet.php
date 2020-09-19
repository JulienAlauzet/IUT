<?php
    
    require_once ('../model/ModelTrajet.php'); 

    class ControllerTrajet {
        
        public static function readAll() {
            $tab_t = ModelTrajet::getAllTrajets();     
            require ('../view/trajet/list.php');
        }
    
        public static function read() {
            $id = $_GET['id'];
            $t = ModelTrajet::getTrajetById($id);    
            require ('../view/trajet/detail.php');  
        }
        
    }
    
?>

