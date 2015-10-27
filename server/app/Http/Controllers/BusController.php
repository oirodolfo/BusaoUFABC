<?php

namespace App\Http\Controllers;

use App\BusRoute;
use App\Place;
use Illuminate\Http\Request;
use App\Http\Requests;
use App\Http\Controllers\Controller;
use Response;

class BusController extends Controller
{


    public function __construct(BusRoute $route, Place $place)
    {
        $this->routes = $route;
        $this->place = $place;
    }

    public function index()
    {
        $routes = $this->routes->getAll();
        return self::out($routes);
    }


    public function getById($id)
    {
        $routes = (object) ["routes" => $this->routes->getById($id)];
        return self::out($routes);
    }

    public function getByLine($id)
    {
        $routes = (object) ["routes" => $this->routes->getByLine($id)];
        return self::out($routes);
    }

    public function getByPlace($id)
    {

        $place = $this->place->get($id);

        $routes = (object) ["place" => $place, "routes" => $this->routes->getByPlace($id)];

        return self::out($routes);
    }

    public function places(){
        $places_query = $this->place->all();

        $places = (object) ["place" => $places_query];

        return self::out($places);
    }

    public static function out($r)
    {
        $response = [];
        $response["meta"] = (object)["code" => 200, "requestId" => 48430487, "timestamp" => new \DateTime()];
        $response["data"] = $r;

        return response()->json($response);
    }
}
