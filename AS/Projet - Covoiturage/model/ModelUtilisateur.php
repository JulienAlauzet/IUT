<?php
    class ModelUtilisateur {
        
        private $login;
        private $nom;
        private $prenom;
        
        
        function __construct($login=NULL, $nom=NULL, $prenom=NULL) {
            if (!is_null($login) && !is_null($nom) && !is_null($prenom)) {
                $this->login = $login;
                $this->nom = $nom;
                $this->prenom = $prenom;
            }
        }

        
        function getLogin() {
            return $this->login;
        }

        function getNom() {
            return $this->nom;
        }

        function getPrenom() {
            return $this->prenom;
        }

        
        function setLogin($login) {
            $this->login = $login;
        }

        function setNom($nom) {
            $this->nom = $nom;
        }

        function setPrenom($prenom) {
            $this->prenom = $prenom;
        }
		
		
		public static function getAllUtilisateurs(){
        $rep = Model::$pdo->query('SELECT * FROM utilisateur');
        $rep->setFetchMode(PDO::FETCH_CLASS, 'ModelUtilisateur');
        return $rep->fetchAll();
    }
		
		
		public static function getUtilisateurByLogin($login) {
            $sql = "SELECT * from utilisateur WHERE login=:nom_tag";
            $req_prep = Model::$pdo->prepare($sql);
            $values = array(
                "nom_tag" => $login,
            );	 
            $req_prep->execute($values);
            $req_prep->setFetchMode(PDO::FETCH_CLASS, 'ModelUtilisateur');
            $tab_util = $req_prep->fetchAll();
            if (empty($tab_util))
                return false;
            return $tab_util[0];
        }

    }
?>

