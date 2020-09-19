<?php
require_once 'Model.php';

class ModelVoiture {
   
    private $marque;
    private $couleur;
    private $immatriculation;
  
  
    public function __construct($m = NULL, $c = NULL, $i = NULL)  {
        if (!is_null($m) && !is_null($c) && !is_null($i)) {
            $this->marque = $m;
            $this->couleur = $c;
            $this->immatriculation = $i;
        }
    }
  
           
    public function getMarque() {
        return $this->marque;  
    }
  
    public function getCouleur() {
        return $this->couleur;
    }
  
    public function getImmatriculation() {
        return $this->immatriculation;
    }
     
  
    public function setMarque($marque2) {
        $this->marque = $marque2;
    } 
  
    function setCouleur($couleur) {
        $this->couleur = $couleur;
    }

    function setImmatriculation($immatriculation) {
        if (strlen($immatriculation) > 8) {
            echo "<p>Impossible de set une immatriculation supérieur à 8 caractères</p>";
        }
        else {
            $this->immatriculation = $immatriculation;
        }
    }
  
  
    public static function getAllVoitures(){
        $rep = Model::$pdo->query('SELECT * FROM voiture');
        $rep->setFetchMode(PDO::FETCH_CLASS, 'ModelVoiture');
        return $rep->fetchAll();
    }
    
    public static function getVoitureByImmat($immat) {
        $sql = "SELECT * from voiture WHERE immatriculation=:nom_tag";
        $req_prep = Model::$pdo->prepare($sql);
        $values = array(
            "nom_tag" => $immat,
        );	 
        $req_prep->execute($values);
        $req_prep->setFetchMode(PDO::FETCH_CLASS, 'ModelVoiture');
        $tab_voit = $req_prep->fetchAll();
        if (empty($tab_voit))
            return false;
        return $tab_voit[0];
    }

    public function save() {
        $sql = "INSERT INTO voiture (immatriculation, marque, couleur)
                VALUES (:tag_immat, :tag_marque, :tag_couleur)";
        $req_prep = Model::$pdo->prepare($sql);
        $values = array(
            "tag_immat" => $this->immatriculation,
            "tag_marque" => $this->marque,
            "tag_couleur" => $this->couleur
        );
        $res = $req_prep->execute($values);
    }
    
}
?>


