package io.example.color.presentation.dto

import java.io.Serializable

/**
 * 色注文リクエストDTOクラス。
 */
data class OrderClothesRequest(
    /** サイズ */
    val size: Int,
    /** 色、16進数形式 */
    val color: String,
    /** フィット感 */
    val fit: String,
    /** 発注数 */
    val lot: Int
) : Serializable
