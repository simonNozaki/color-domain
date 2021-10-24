package io.example.color.domain.model

import io.example.color.domain.type.FitEnum
import io.example.color.domain.type.Lot
import io.example.color.domain.type.SizeEnum
import io.example.color.domain.type.Uuid

/**
 * 注文エンティティ
 */
data class Order(
    /** UUID */
    val id: Uuid,
    /** 受注ロット */
    val lot: Lot,
    /** サイズ */
    val size: SizeEnum,
    /** 色 */
    val color: Color,
    /** フィット感 */
    val fit: FitEnum
)
