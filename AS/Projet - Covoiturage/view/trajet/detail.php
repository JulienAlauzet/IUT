<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Détail du trajet</title>
    </head>
    <body>
        <?php
			require "../view/general/navigation.php";
			//require "../model/ModelUtilisateur.php";
			$t_pass = ModelTrajet::findPassagers($t->get('id'));
			$conducteur = ModelUtilisateur::getUtilisateurbyLogin($t->get('conducteur_login'));
            echo '<p> Trajet n° ' . $t->get('id') . ' : </p>
			<p>' . $t->get('depart') . ' -> ' . $t->get('arrivee') . 
			'<br />Date : ' . $t->get('date') . 
			'<br />Prix : ' . $t->get('prix') . ' €
			<br />Nombre de places : ' . $t->get('nbplaces') .
			'<br />Conducteur sur le trajet : ' . $conducteur->getPrenom() . ' ' . $conducteur->getNom() . '</p>
			<p>Liste des passagers : <br />';
			foreach ($t_pass as $p) {
				echo $p->getPrenom() . ' ' . $p->getNom() . '<br />';
			}	
        ?>
    </body>
</html>