<?php
    require_once '../config/Conf.php';

    Class Model {
        public static $pdo;
        
        public static function Init() {
            $hostname = Conf::getHostname();
            $database_name = Conf::getDatabase();
            $login = Conf::getLogin();
            $password = Conf::getPassword();
            try {
                self::$pdo = new PDO("mysql:host=$hostname;dbname=$database_name",$login,$password);
            } catch(PDOException $e) {
                echo $e->getMessage();
                die();
            }
        }
    }
    
    Model::Init();
    
?>
