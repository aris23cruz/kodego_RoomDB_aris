package com.kodego.inventory.app.roomdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Employee (
    var name:String,
    var salary:Int
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}