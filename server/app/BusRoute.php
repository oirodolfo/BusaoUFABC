<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class BusRoute extends Model
{
    //
    protected $table = 'routes';

    function place(){
        return $this->belongsTo('App\Place', 'place_id');
    }

    function getAll(){
        return $this->with('place')
            ->orderBy('time', 'desc')
            ->get();
    }

    function getByPlace($id){
        return $this->select(['id', 'line', 'time'])->where('place_id',$id)
            ->get();
    }

    function getByLine($id){
        return $this->with('place')
            ->where('line',$id)
            ->get();
    }


}
