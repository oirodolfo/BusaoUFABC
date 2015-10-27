<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Place extends Model
{
    protected $table = 'places';

    public function route(){
        return $this->belongsTo('App\BusRoute', 'place_id');
    }

    function get($id){
        return $this->find($id);
    }

  }
