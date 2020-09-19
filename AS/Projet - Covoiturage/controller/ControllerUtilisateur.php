<?php
    
    require_once ('../model/ModelUtilisateur.php'); 

    class ControllerUtilisateur {
        
        public static function readAll() {
            $tab_u = ModelUtilisateur::getAllUtilisateurs();     
            require ('../view/utilisateur/list.php');
        }
    
        public static function read() {
            $login = $_GET['login'];
            $u = ModelUtilisateur::getUtilisateurByLogin($login);    
            require ('../view/utilisateur/detail.php');  
        }
        
    }
    
?>
