package Aquarium

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

fun main(args: Array<String>) {

    val ClassObj = Plant::class

    for(method in ClassObj.declaredMemberFunctions){
        println(method.name)
    }

    println("----")
    for(property in ClassObj.declaredMemberProperties){
        for (annotation in property.getter.annotations){
            println(annotation.annotationClass.simpleName)
        }

    }

    println("----")
    for(annotation in ClassObj.annotations){
        println(annotation.annotationClass.simpleName)
    }

    println("----")
    for(annotation in ClassObj.annotations){
        println(annotation.annotationClass.simpleName)
    }

    println()
}


@ImAPlant class Plant{
    fun trim(){}
    fun fertilize(){}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}


annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections(){
    val ClassObj = Plant::class

    // print all annotations
    for(annotation in ClassObj.annotations){
        println(annotation.annotationClass.simpleName)
    } // ImAPlant

    // find one annotation, or null
    val annotated = ClassObj.findAnnotation<ImAPlant>()

    annotated?.apply {
        println("Found a plant annotation!")
    } // Found a plant annotation!

}