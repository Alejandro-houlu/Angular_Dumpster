
export const orderDb = new Map<string,Order>()

export interface Order{
    name: string
    mobile: number
    items: Item[]

}

export interface Item{
    item:string
    quantity: number
}