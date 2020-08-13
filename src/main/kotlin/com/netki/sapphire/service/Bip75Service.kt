package com.netki.sapphire.service

import com.netki.TransactId
import com.netki.sapphire.model.InvoiceRequestPayload
import com.netki.sapphire.model.PaymentAckPayload
import com.netki.sapphire.model.PaymentPayload
import com.netki.sapphire.model.PaymentRequestPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bip75Service {

    @Autowired
    private lateinit var tid: TransactId

    fun createInvoiceRequest(invoiceRequestPayload: InvoiceRequestPayload) = tid.createInvoiceRequest(
        invoiceRequestPayload.invoiceRequestParameters,
        invoiceRequestPayload.ownersParameters,
        invoiceRequestPayload.senderParameters,
        invoiceRequestPayload.attestationsRequested
    )

    fun isInvoiceRequestValid(invoiceRequestBinary: ByteArray) = tid.isInvoiceRequestValid(invoiceRequestBinary)

    fun parseInvoiceRequest(invoiceRequestBinary: ByteArray) = tid.parseInvoiceRequest(invoiceRequestBinary)

    fun createPaymentRequest(paymentRequestPayload: PaymentRequestPayload) = tid.createPaymentRequest(
        paymentRequestPayload.paymentRequestParameters,
        paymentRequestPayload.ownersParameters,
        paymentRequestPayload.senderParameters,
        paymentRequestPayload.attestationsRequested,
        paymentRequestPayload.paymentRequestParametersVersion
    )

    fun isPaymentRequestValid(paymentRequestBinary: ByteArray) = tid.isPaymentRequestValid(paymentRequestBinary)

    fun parsePaymentRequest(paymentRequestBinary: ByteArray) = tid.parsePaymentRequest(paymentRequestBinary)

    fun createPayment(paymentPayload: PaymentPayload) = tid.createPayment(
        paymentPayload.paymentParameters,
        paymentPayload.ownersParameters
    )

    fun isPaymentValid(paymentBinary: ByteArray) = tid.isPaymentValid(paymentBinary)

    fun parsePayment(paymentBinary: ByteArray) = tid.parsePayment(paymentBinary)

    fun createPaymentAck(paymentAckPayload: PaymentAckPayload) = tid.createPaymentAck(
        paymentAckPayload.payment,
        paymentAckPayload.memo
    )

    fun isPaymentAckValid(paymentAckBinary: ByteArray) = tid.isPaymentAckValid(paymentAckBinary)

    fun parsePaymentAck(paymentAckBinary: ByteArray) = tid.parsePaymentAck(paymentAckBinary)
}
