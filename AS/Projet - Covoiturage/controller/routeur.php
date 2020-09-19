<?php

    require_once 'ControllerVoiture.php';
	require_once 'ControllerTrajet.php';
	require_once 'ControllerUtilisateur.php';

    $action = $_GET['action'];
	$controller = $_GET['controller'];

    $controller::$action(); 
    
?>
