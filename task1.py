class Handler:
    def __init__(self, denomination):
        self.denomination = denomination
        self.next_handler = None

    def set_next(self, handler):
        self.next_handler = handler

    def handle(self, amount):
        if amount >= self.denomination:
            num_coins = amount // self.denomination
            remainder = amount % self.denomination
            print(f"Dispensing {num_coins} coins of {self.denomination} units")
            if remainder != 0 and self.next_handler:
                self.next_handler.handle(remainder)
            elif remainder != 0:
                print(f"Cannot dispense the remaining {remainder} units with available denominations.")
        else:
            if self.next_handler:
                self.next_handler.handle(amount)
            else:
                print(f"Cannot dispense {amount} units with available denominations.")

# Setting up the chain
handler_50 = Handler(50)
handler_20 = Handler(20)
handler_10 = Handler(10)
handler_5 = Handler(5)
handler_1 = Handler(1)

handler_50.set_next(handler_20)
handler_20.set_next(handler_10)
handler_10.set_next(handler_5)
handler_5.set_next(handler_1)

# Processing the request
amount_to_dispense = 93
handler_50.handle(amount_to_dispense)