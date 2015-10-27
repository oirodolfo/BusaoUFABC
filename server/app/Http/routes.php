<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/


Route::group(['prefix' => 'api'], function ()
{
    Route::group(['prefix' => 'v1'], function ()
    {
        Route::get('all', ['uses' => 'BusController@index']);

        Route::get('line/{id}', function ($id)
        {
            $app = app();
            $controller = $app->make('App\Http\Controllers\BusController');
            return $controller->callAction('getByLine', $parameters = ['id' => $id]);
        });

        Route::get('place/{id}', function ($id)
        {
            $app = app();
            $controller = $app->make('App\Http\Controllers\BusController');
            return $controller->callAction('getByPlace', $parameters = ['id' => $id]);
        });

        Route::get('places',['uses'=>'BusController@places']);



    });

});
