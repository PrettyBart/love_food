package Class

import Model.Class.Ingredients
import Model.Class.createIngredient
import Model.Class.deleteIngredient

class Menu {

}
fun mainMenu(){
    var mainMenuChecker = true
    while(mainMenuChecker){
    println("/////KcalCal\\\\" +
            "[1]. Ingredients" +
            "[2]. Receipts" +
            "[3]. Meal plans" +
            "[4]. Calculators" +
            "[5]. Storage" +
            "\n" +
            "[6]. Your profile" +
            "[7]. Statistics" +
            "[8]. Eat" +
            "[9]. Dashboard" +
            "\n" +
            "[0]. Close app")
    }
    var mainMenuControler = readln().toInt()!!
    when(mainMenuControler){
        1 -> {ingredientMenu()}
        2 -> {receiptsMenu()}
        3 -> {plansMenu()}
        4 -> {calculatorsMenu()}
        5 -> {storageMenu()}
        6 -> {profileMenu()}
        7 -> {statisticsMenu()}
        8 -> {eatMenu()}
        9 -> {dashboardMenu()}
        0 -> {println("Are You sure that You want to close app?[Y/N]")
                mainMenuChecker = twoStepVerification()
        }
        else -> {}
    }
}



fun ingredientMenu() {
    var ingredientMenuChecker = true
    while(ingredientMenuChecker){
        println("/////Ingredients\\\\" +
                "[1]. New" +
                "[2]. Explore" +
                "[3]. Delete" +
                "\n" +
                "[0]. Exit Ingredients")
    }
    var ingredientMenuControler = readln().toInt()!!
    when(ingredientMenuControler){
        1 -> {initNewIngredient()}
        2 -> {initExploreIngredient()}
        3 -> {initDeleteIngredient()}

        0 -> {println("Are You sure that You want to exit Ingredients?[Y/N]")
            ingredientMenuChecker = twoStepVerification()
        }
        else -> {}
    }
}



fun receiptsMenu() {
    TODO("Not yet implemented")
}

fun plansMenu() {
    TODO("Not yet implemented")
}

fun calculatorsMenu() {
    TODO("Not yet implemented")
}

fun storageMenu() {
    TODO("Not yet implemented")
}

fun profileMenu(){
    TODO("Not yet implemented")
}
fun statisticsMenu() {
    TODO("Not yet implemented")
}

fun eatMenu(){
    TODO("Not yet implemented")
}
fun dashboardMenu() {
    TODO("Not yet implemented")
}

fun twoStepVerification(): Boolean {
    val twoStepConfirmationChecker = readln()
    if (twoStepConfirmationChecker == "Y" || twoStepConfirmationChecker =="y"){
    return true}
    else if (twoStepConfirmationChecker == "N" || twoStepConfirmationChecker =="n"){
    return false}
    else return false
}



fun initNewIngredient(){
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
    createIngredient(name,kcal,1,"g",fat,cholesterol,sodium,carbohydrates,protein)
}
fun initExploreIngredient() {
    TODO("Not yet implemented")
}

fun initDeleteIngredient() {
    TODO("Not yet implemented")
}
fun editIngredientMenu(newIngredient: Ingredients){
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
                //deleteIngredient(name)
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
}}