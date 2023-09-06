package Model.Class

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException
import java.lang.Error
import java.util.Scanner

@Serializable
class Ingredients(
    var name: String,
    var calories: Int,
    val weight: Int,
    val valueUoM: String,
    var totalFat: Int,
    var cholesterol: Int,
    var sodium: Int,
    var totalCarbohydrate: Int,
    var protein: Int){
    init {
    println("New ingredient called ${name} that have " +
    "\n${calories}${valueUoM} kcal, " +
    "\n${totalFat}${valueUoM} of fat, " +
    "\n${cholesterol}${valueUoM} of cholesterol, " +
    "\n${sodium}${valueUoM} of sodium, " +
    "\n${totalCarbohydrate}${valueUoM} of carbs, " +
    "\nand ${protein}${valueUoM} of protein\n " +
    "in ${weight}${valueUoM}" +
    "\n was now created")
}}

fun createIngredient(name: String, calories: Int, weight: Int, valueUoM: String, totalFat: Int, cholesterol: Int, sodium: Int,totalCarbohydrate:Int,protein: Int): Ingredients{



    //object
    val newIngredient = Ingredients(name,calories,1,"g",totalFat,cholesterol,sodium,totalCarbohydrate,protein)
    println(Json.encodeToString(newIngredient))

    //file handler block
    val fileName = "${name}.json"
    val file = File(fileName)
    try {
        file.createNewFile()
        println("File $fileName is created")
        try {
            file.writeText(Json.encodeToString(newIngredient))
        } catch (e:Error){
            println("Cant write into file")
        }

    } catch(e:Error){
        println("File $fileName couldnt be created")
    }

    return newIngredient
}
fun readIngredient(name:String): Ingredients{
    val fileName = "${name}.json"
    val file = File(fileName)
    var data=""
    try {
        data = file.readText()
        println(data)
    } catch (e:Error){
        println("Cant read this file")
    }
    catch (e:IOException){
        println("IO error for read file")
    }
    val newIngredient = Json.decodeFromString<Ingredients>(data)

    return newIngredient
}
fun editIngredient(name: String){
    val fileName = "${name}.json"
    val file = File(fileName)
    var data:String = ""
    try {
        data = file.readText()
        println(data)
    } catch (e:Error){
        println("Cant read this file")
    }
    catch (e:IOException){
        println("IO error for read file")
    }
    val newIngredient = Json.decodeFromString<Ingredients>(data)
    var editMenuChecker = true
    while (editMenuChecker){
        println("You are editing ingredient ${newIngredient.name}" +
                "\nPlease select which field You want to edit now." +
                "\n1. Name" +
                "\n2. Calories" +
                "\n3. Fat" +
                "\n4. Cholesterol" +
                "\n5. Sodium" +
                "\n6. Carbohydrates" +
                "\n7. Protein" +
                "\n8. Save changes" +
                "\n9. Exit without save" +
                "\n" +
                "\n" +
                "\n0. Copy that ingredient" +
                "")
        var editMenuControler = readln().toInt()!!
        when(editMenuControler){
            1 -> {
                println("Please provide a new name for Ingredient ${newIngredient.name}:")
                newIngredient.name = readln()
                println("New name of ingredient is: ${newIngredient.name}")
            }
            2 -> {
                println("Please provide a new value of calories for Ingredient ${newIngredient.calories}:")
                newIngredient.calories = readln().toInt()!!
                println("New calories of ingredient is: ${newIngredient.calories}")
            }
            3 -> {
                println("Please provide a new value of total Fat for Ingredient ${newIngredient.totalFat}:")
                newIngredient.totalFat = readln().toInt()
                println("New total Fat of ingredient is: ${newIngredient.totalFat}")
            }
            4 -> {
                println("Please provide a new value of cholesterol for Ingredient ${newIngredient.cholesterol}:")
                newIngredient.cholesterol = readln().toInt()
                println("New cholesterol of ingredient is: ${newIngredient.cholesterol}")
            }
            5 -> {
                println("Please provide a new value of sodium for Ingredient ${newIngredient.sodium}:")
                newIngredient.sodium = readln().toInt()
                println("New sodium of ingredient is: ${newIngredient.sodium}")
            }
            6 -> {
                println("Please provide a new value of total Carbohydrate for Ingredient ${newIngredient.totalCarbohydrate}:")
                newIngredient.totalCarbohydrate = readln().toInt()
                println("New total Carbohydrate of ingredient is: ${newIngredient.totalCarbohydrate}")
            }
            7 -> {
                println("Please provide a new value of protein for Ingredient ${newIngredient.protein}:")
                newIngredient.protein = readln().toInt()
                println("New protein of ingredient is: ${newIngredient.protein}")
            }
            8 -> {
                println("Are You really want to save changes?[Y/N]")
                val twoStepConfirmationChecker = readln()
                if (twoStepConfirmationChecker == "Y" || twoStepConfirmationChecker =="y"){
                   deleteIngredient(name)
                   createIngredient(
                       newIngredient.name,
                       newIngredient.calories,
                       1,
                       "g",
                       newIngredient.totalFat,
                       newIngredient.cholesterol,
                       newIngredient.sodium,
                       newIngredient.totalCarbohydrate,
                       newIngredient.protein
                   )
                }
                    else if (twoStepConfirmationChecker == "N" || twoStepConfirmationChecker =="n"){
                        editMenuChecker = false
                    }
                        else{ println("really?") }
            }
            9 -> {
                println("Are You really want to exit without save changes?[Y/N]")
                val twoStepConfirmationChecker = readln()
                if (twoStepConfirmationChecker == "Y" || twoStepConfirmationChecker =="y"){
                    editMenuChecker = false
                }
                else if (twoStepConfirmationChecker == "N" || twoStepConfirmationChecker =="n"){
                }
                else{ println("really?") }
            }
            0 -> { //todo trycatch?
                println("Please provide a new name for Ingredient ${newIngredient.name}:")
                newIngredient.name = readln()
                println("New name of ingredient is: ${newIngredient.name}")
                createIngredient(
                    newIngredient.name,
                    newIngredient.calories,
                    1,
                    "g",
                    newIngredient.totalFat,
                    newIngredient.cholesterol,
                    newIngredient.sodium,
                    newIngredient.totalCarbohydrate,
                    newIngredient.protein
                )
            }
            else -> println("really?")
        }
    }
}
fun deleteIngredient(name: String){
    val fileName = "${name}.txt"
    val file = File(fileName)
    try {
        val data = file.delete()
        println("Ingedient $name is removed")
    } catch (e:Error){
        println("Cant remove this file")
    }
}
fun calculateValues(ingredient: Ingredients, quantity: Int ): Ingredients{
    val calculatedIngredient = Ingredients(
        ingredient.name,
        ingredient.weight * quantity,
        quantity,
        ingredient.valueUoM,
        ingredient.totalFat * quantity,
        ingredient.cholesterol * quantity,
        ingredient.sodium * quantity,
        ingredient.totalCarbohydrate * quantity,
        ingredient.protein * quantity)
    return calculatedIngredient
}

