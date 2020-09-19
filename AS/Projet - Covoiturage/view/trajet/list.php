<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Liste des trajets</title>
    </head>
    <body>
        <?php
        require "../view/general/navigation.php";
        foreach ($tab_t as $t) {
            $id=$t->get('id');
            echo '<p>Trajet n° ' . "<a href='routeur.php?action=read&id=$id&controller=ControllerTrajet'> $id </a>" . '</p>';
        }
        ?>
    </body>
</html>
