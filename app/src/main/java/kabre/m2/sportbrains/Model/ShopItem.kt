package kabre.m2.sportbrains.Model

data class ShopItem(
    val id: Int,
    val imageResId: Int,       // ID de la ressource d'image
    val price: Int,             // Prix de l'élément
    val discountText: Int,   // Texte de réduction
    val formattedPrice: Double,  // Prix
    val metode: String
)
