package Model.Class

import java.io.File
import java.io.IOException
import java.lang.Error

class Ingredients(
    val name: String,
    val calories: Int,
    val weight: Int,
    val valueUoM: String,
    val totalFat: Int,
    val cholesterol: Int,
    val sodium: Int,
    val totalCarbohydrate: Int,
    val protein: Int)

fun createIngredient(): Ingredients{
    //UI handler
    println("Hello, What ingredient You wand to add? Please provide name:")
    val name: String = readln()
    println("Your ingredient is: $name, please provide how many calories it have in 1gram.")
    val kcal: Int = readln().toInt()
    println("Your ingredient is: $name, please provide how many fat it have in 1gram.")
    val fat: Int = readln().toInt()
    println("Your ingredient is: $name, please provide how many cholesterol it have in 1gram.")
    val cholesterol: Int = readln().toInt()
    println("Your ingredient is: $name, please provide how many sodium it have in 1gram.")
    val sodium: Int = readln().toInt()
    println("Your ingredient is: $name, please provide how many carbs it have in 1gram.")
    val carbohydrates: Int = readln().toInt()
    println("Your ingredient is: $name, please provide how many protein it have in 1gram.")
    val protein: Int = readln().toInt()
    //object
    val newIngredient = Ingredients(name,kcal,1,"g",fat,cholesterol,sodium,carbohydrates,protein)
    //file handler block
    val fileName = "${name}.txt"
    val file = File(fileName)
    try {
        file.createNewFile()
        println("File $fileName is created")
        try {
            file.writeText("New ingredient called ${newIngredient.name} that have " +
                    "\n${newIngredient.calories}${newIngredient.valueUoM} kcal, " +
                    "\n${newIngredient.totalFat}${newIngredient.valueUoM} of fat, " +
                    "\n${newIngredient.cholesterol}${newIngredient.valueUoM} of cholesterol, " +
                    "\n${newIngredient.sodium}${newIngredient.valueUoM} of sodium, " +
                    "\n${newIngredient.totalCarbohydrate}${newIngredient.valueUoM} of carbs, " +
                    "\nand ${newIngredient.protein}${newIngredient.valueUoM} of protein\n " +
                    "in ${newIngredient.weight}${newIngredient.valueUoM}" +
                    "\nwas now created")
        } catch (e:Error){
            println("Cant write into file")
        }
        catch (e:IOException){
            println("IO error for write to file")
        }
    } catch(e:Error){
        println("File $fileName couldnt be created")
    }
    catch (e:IOException){
        println("IO error for new file")
    }
    //TODO object init message instead of free text in function
//    println("New ingredient called ${newIngredient.name} that have " +
//            "\n${newIngredient.calories}${newIngredient.valueUoM} kcal, " +
//            "\n${newIngredient.totalFat}${newIngredient.valueUoM} of fat, " +
//            "\n${newIngredient.cholesterol}${newIngredient.valueUoM} of cholesterol, " +
//            "\n${newIngredient.sodium}${newIngredient.valueUoM} of sodium, " +
//            "\n${newIngredient.totalCarbohydrate}${newIngredient.valueUoM} of carbs, " +
//            "\nand ${newIngredient.protein}${newIngredient.valueUoM} of protein\n " +
//            "in ${newIngredient.weight}${newIngredient.valueUoM}" +
//            "\n was now created")
    return newIngredient
}

//fun calculateValues(ingredient: Ingredients, quantity: Int ): Ingredients{
//    val calculatedIngredient = Ingredients(
//        ingredient.name,
//        ingredient.weight * quantity,
//        quantity,
//        ingredient.valueUoM,
//        ingredient.totalFat * quantity,
//        ingredient.cholesterol * quantity,
//        ingredient.sodium * quantity,
//        ingredient.totalCarbohydrate * quantity,
//        ingredient.protein * quantity)
//    return calculatedIngredient
//}
fun readIngredient(name:String)//: Ingredients
{
    val fileName = "${name}.txt"
    val file = File(fileName)
    try {
        val data = file.readText()
        println(data)
    } catch (e:Error){
        println("Cant read this file")
    }
    catch (e:IOException){
        println("IO error for read file")
    }
    catch (e:IOException){
        println("IO error for new file")
    }

//    val name: String = readln()
//    val kcal: Int = readln().toInt()
//    val fat: Int = readln().toInt()
//    val cholesterol: Int = readln().toInt()
//    val sodium: Int = readln().toInt()
//    val carbohydrates: Int = readln().toInt()
//    val protein: Int = readln().toInt()
//
//    val newIngredient = Ingredients(name,kcal,1,"g",fat,cholesterol,sodium,carbohydrates,protein)

    return //newIngredient
}

