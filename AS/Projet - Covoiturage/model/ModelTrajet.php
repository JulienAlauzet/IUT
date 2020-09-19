<?php
    class ModelTrajet {
        
        private $id;
        private $depart;
        private $arrivee;
        private $date;
        private $nbplaces;
        private $prix;
        private $conducteur_login;
        
        
        function __construct($data = NULL) {
			if (!is_null($data)) {
				foreach($data as $nom_attribut => $value) 
					$this->$nom_attribut = $value;
			}
        }
		     
        
        function get ($nom_attribut) {
            return $this->$nom_attribut;
        }
        
        
        function set ($nom_attribut, $valeur) {
            $this->$nom_attribut = $valeur;
        }
        
        
        public static function getAllTrajets(){
            $rep = Model::$pdo->query('SELECT * FROM trajet');
            $rep->setFetchMode(PDO::FETCH_CLASS, 'ModelTrajet');
            return $rep->fetchAll();
        }
        
        public static function getTrajetById($id) {
            $sql = "SELECT * from trajet WHERE id=:nom_tag";
            $req_prep = Model::$pdo->prepare($sql);
            $values = array(
                "nom_tag" => $id,
            );	 
            $req_prep->execute($values);
            $req_prep->setFetchMode(PDO::FETCH_CLASS, 'ModelTrajet');
            $tab_traj = $req_prep->fetchAll();
            if (empty($tab_traj))
                return false;
            return $tab_traj[0];
        }
        
       
        public static function findPassagers($id) {
            $sql = "SELECT login, nom, prenom
                     FROM utilisateur 
                     INNER JOIN passager ON utilisateur.login = passager.utilisateur_login 
                     WHERE passager.trajet_id = :trajet_id";
            $req_prep = Model::$pdo->prepare($sql);
            $values = array(
                "trajet_id" => $id,
            );
            $res = $req_prep->execute($values);
            $req_prep->setFetchMode(PDO::FETCH_CLASS, 'ModelUtilisateur');
            $tab_utilisateurs = $req_prep->fetchAll();
            if (empty($tab_utilisateurs))
                return false;
            return $tab_utilisateurs; 
        }
    }
?>
