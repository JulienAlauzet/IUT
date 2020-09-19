<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="utf-8" />
        <title> Création de voiture </title>
    </head>
   
    <body>
        <?php require "../view/general/navigation.php"; ?>
        <form method="get" action="../controller/routeur.php">
            <fieldset>
                <legend>Nouvelle voiture :</legend>
                    <p>
                        <label for="immat_id">Immatriculation</label> :
                        <input type="text" placeholder="Ex : 256AB34" name="immat" id="immat_id" required/>
                    </p>
                    <p>
                        <label for="marque_id">Marque</label> :
                        <input type="text" placeholder="Ex : Toyota" name="marque" id="marque_id" required/>
                    </p>
                    <p>
                        <label for="couleur_id">Couleur</label> :
                        <input type="text" placeholder="Ex : bleu" name="couleur" id="couleur_id" required/>
                    </p>
                    <p>
                    <input type='hidden' name='action' value='created'>
					<input type='hidden' name='controller' value='ControllerVoiture'>
                    </p>
                    <p>
                        <input type="submit" value="Envoyer" />
                    </p>
                    
            </fieldset> 
        </form>
    </body>
</html> 