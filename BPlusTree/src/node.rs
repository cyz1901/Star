struct node<T>{
    m: i64,
    h: i64,
    next: node<T>,
    array:Vec<entry<T>>

}
struct entry<T>{
    key: i64,
    value: T
}